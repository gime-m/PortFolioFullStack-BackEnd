package com.argentinaPrograma.PortFolio.DTO.GetPutDTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public final class GetPutPersona extends IdPersona{
    private Long id;
    private String nombre;
    private String apellido;
    private String ocupacion;
    private String descripcion;
    private String ubicacion;
    private String lugarTrabajo;
    private String email;
    private String telefono;
    private String github;
    private String imagenPerfil;
    private String banner;
    private String imagenFondo;
    private Long temaId;
}
