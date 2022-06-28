package com.argentinaPrograma.PortFolio.DTO.GetPutDTO;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public final class GetPutProyecto extends AbstractGetPut{
    private String descripcion;
    private Date fecha;
    private String link;
    private String imagen; 
}
