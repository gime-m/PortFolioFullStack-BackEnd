package com.argentinaPrograma.PortFolio.Security.Filter;

import com.argentinaPrograma.PortFolio.DTO.AuthResponse;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Slf4j 
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    private final String secretKey;
    private final AuthenticationManager authManager;  
  
    public CustomAuthenticationFilter(String secretKey, AuthenticationManager authManager){
        this.authManager = authManager;
        this.secretKey = secretKey;
    };
    
    //Autenticacion con usuario y contraseña
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UsernamePasswordAuthenticationToken authToken= new UsernamePasswordAuthenticationToken (username, password);
        return authManager.authenticate(authToken);
    }

    //aqui creamos el JWT
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth) throws IOException, ServletException {
        User user = (User) auth.getPrincipal();
        Algorithm alg = Algorithm.HMAC256(secretKey.getBytes());
        String accessToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(new Date().getTime() + 10*60*1000))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(alg);  
        String refreshToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(new Date().getTime() + 360*60*1000))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(alg); 
        
        //response.setHeader("accessToken", accessToken);
   
        AuthResponse authResp = new AuthResponse(true, accessToken, refreshToken, user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        response.setContentType(APPLICATION_JSON_VALUE);      
        new ObjectMapper().writeValue(response.getOutputStream(),authResp);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        AuthResponse authResp = new AuthResponse(false, "", "", new ArrayList<>());
        response.setContentType(APPLICATION_JSON_VALUE);      
        new ObjectMapper().writeValue(response.getOutputStream(),authResp);
    }   
    
}