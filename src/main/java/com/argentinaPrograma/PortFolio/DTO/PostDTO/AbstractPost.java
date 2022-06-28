package com.argentinaPrograma.PortFolio.DTO.PostDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter @Setter
public abstract class AbstractPost {
    private String titulo;
    private long personaId;
    private int displayOrder;
}
