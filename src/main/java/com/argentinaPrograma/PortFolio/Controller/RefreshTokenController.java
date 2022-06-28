package com.argentinaPrograma.PortFolio.Controller;

import com.argentinaPrograma.PortFolio.DTO.AuthDTO.AuthResponse;
import com.argentinaPrograma.PortFolio.Model.Rol;
import com.argentinaPrograma.PortFolio.Model.Usuario;
import com.argentinaPrograma.PortFolio.Service.UsuarioServiceInterface;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefreshTokenController {
    
    @Autowired
    private UsuarioServiceInterface userServ;
    
    @Value("${jwt_secret}")
    public String secret;
    
    @GetMapping("/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String authHeader = request.getHeader(AUTHORIZATION);
        if(authHeader != null && authHeader.startsWith("Bearer ")){
            try {
                String refreshToken = authHeader.substring("Bearer ".length());
                Algorithm alg = Algorithm.HMAC256(secret.getBytes());
                JWTVerifier verifier = JWT.require(alg).build();
                DecodedJWT decodJWT = verifier.verify(refreshToken);
                String username = decodJWT.getSubject();
                Usuario user = userServ.getUsuario(username);
  
                String accessToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(new Date().getTime() + 10*60*1000))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles",user.getRoles().stream().map(Rol::getNombre).collect(Collectors.toList()))
                .sign(alg);  

                AuthResponse authResp = new AuthResponse(true, accessToken, refreshToken, user.getRoles().stream().map(Rol::getNombre).collect(Collectors.toList()));
                response.setContentType(APPLICATION_JSON_VALUE);      
                new ObjectMapper().writeValue(response.getOutputStream(),authResp); 
                } catch (Exception exception) {
                    
                    //System.out.print(exception.getMessage());
                    response.setHeader("error", exception.getMessage());
                    response.setStatus(FORBIDDEN.value());
                    response.sendError(FORBIDDEN.value());
                    Map<String, String> error = new HashMap<>();
                    error.put("error_message", exception.getMessage());
                    response.setContentType(APPLICATION_JSON_VALUE);      
                    new ObjectMapper().writeValue(response.getOutputStream(),error);
                }
                
        } else {
           throw new RuntimeException("No se recibió refesh token");              
        } 
    }
}
