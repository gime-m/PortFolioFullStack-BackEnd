package com.argentinaPrograma.PortFolio.DTO.AuthDTO;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class AuthResponse {
    public Boolean successful;
    public String accessToken;
    public String refreshToken;
    public List<String> roles;
}
