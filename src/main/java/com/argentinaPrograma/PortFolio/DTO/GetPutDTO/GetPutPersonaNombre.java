package com.argentinaPrograma.PortFolio.DTO.GetPutDTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public final class GetPutPersonaNombre extends IdPersona{
    private String nombre;
    private String apellido;
    private String ocupacion;
}
