package com.argentinaPrograma.PortFolio.DTO.PostDTO;

import java.sql.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter @Setter
public final class PostEducacion extends AbstractPost{
    private String descripcion;
    private String institucion;
    private Date fechaInicio;
    private Date fechaFin;
    private Boolean isCurrent;
    private String imagen;
    
}
