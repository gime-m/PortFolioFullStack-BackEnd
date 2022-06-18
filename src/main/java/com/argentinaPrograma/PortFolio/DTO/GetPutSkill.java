package com.argentinaPrograma.PortFolio.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class GetPutSkill {
    
    private Long id;
    private String titulo;
    private int valor; 
    private String tipo; 
    private Long personaId;   
}
