package com.argentinaPrograma.PortFolio.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class GetPutPersona {
    private Long id;
    private String nombre;
    private String apellido;
    private String ocupacion;
    private String descripcion;
    private String ubicacion;
    private String lugarTrabajo;
    private String email;
    private String telefono;
    private String imagenPerfil;
    private String banner;
    private String github;
}
