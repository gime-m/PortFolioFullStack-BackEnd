package com.argentinaPrograma.PortFolio.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PostSkill {
    
    private String titulo;
    private int valor; 
    private String tipo;     
    private long personaId;
    private int displayOrder;
}
