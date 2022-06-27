package com.argentinaPrograma.PortFolio.DTO;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PostProyecto {
    private String titulo;
    private String descripcion;
    private Date fecha;
    private String link;
    private String imagen; 
    private long personaId;
    private int displayOrder;
}
