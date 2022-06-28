package com.argentinaPrograma.PortFolio.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class GetPutPersonaDatos extends GetPutPersona2{
    private String ubicacion;
    private String lugarTrabajo;
    private String email;
    private String telefono;
    private String github;
}
