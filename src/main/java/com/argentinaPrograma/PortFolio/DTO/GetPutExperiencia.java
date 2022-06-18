package com.argentinaPrograma.PortFolio.DTO;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class GetPutExperiencia {
    
    private Long id;
    private String titulo;
    private String descripcion;
    private String lugar;
    private Date fechaInicio;
    private Date fechaFin;
    private Boolean isCurrent;
    private String imagen;  
    private Long personaId;
}
