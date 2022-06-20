package com.argentinaPrograma.PortFolio.Security;

import com.argentinaPrograma.PortFolio.Security.Filter.CustomAuthenticationFilter;
import com.argentinaPrograma.PortFolio.Security.Filter.CustomAuthorizationFilter;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration @EnableWebSecurity @RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Value("${jwt_secret}")
    public String secret;
    
    private final UserDetailsService userDetServ;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetServ).passwordEncoder(bCryptPasswordEncoder);
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.cors();
        
        //aquí podemos designar que roles pueden acceder a qué métodos, con que path
        http.authorizeRequests().antMatchers("/login/**", "/refresh/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET).hasAnyAuthority("USER","ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.POST).hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.PUT).hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE).hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll();
        http.authorizeRequests().anyRequest().authenticated();
        
        http.addFilter(new CustomAuthenticationFilter(secret, authenticationManagerBean()));
        http.addFilterBefore(new CustomAuthorizationFilter(secret), UsernamePasswordAuthenticationFilter.class);
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean()throws Exception {
        return super.authenticationManager();
    }
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost:8080"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE", "OPTIONS"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
