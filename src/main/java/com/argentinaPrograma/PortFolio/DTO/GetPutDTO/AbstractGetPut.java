package com.argentinaPrograma.PortFolio.DTO.GetPutDTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class AbstractGetPut {
    private Long id;
    private String titulo;
    private Long personaId;
    private int displayOrder;
}
