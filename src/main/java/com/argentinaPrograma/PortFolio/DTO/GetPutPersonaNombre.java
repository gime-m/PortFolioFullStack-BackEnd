package com.argentinaPrograma.PortFolio.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class GetPutPersonaNombre extends GetPutPersona2{
    private String nombre;
    private String apellido;
    private String ocupacion;
}
