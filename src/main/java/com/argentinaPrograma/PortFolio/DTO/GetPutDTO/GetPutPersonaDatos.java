package com.argentinaPrograma.PortFolio.DTO.GetPutDTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public final class GetPutPersonaDatos extends IdPersona{
    private String ubicacion;
    private String lugarTrabajo;
    private String email;
    private String telefono;
    private String github;
}
