package com.argentinaPrograma.PortFolio.DTO.PostDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter @Setter
public final class PostSkill extends AbstractPost{
    private int valor; 
    private String tipo;     
}
