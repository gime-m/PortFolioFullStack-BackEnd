package com.argentinaPrograma.PortFolio.DTO.GetPutDTO;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public final class GetPutEducacion extends AbstractGetPut {
    private String descripcion;
    private String institucion;
    private Date fechaInicio;
    private Date fechaFin;
    private Boolean isCurrent;
    private String imagen;  
}
