package com.argentinaPrograma.PortFolio.DTO.PostDTO;

import java.sql.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter @Setter
public final class PostProyecto extends AbstractPost{
    private String descripcion;
    private Date fecha;
    private String link;
    private String imagen; 
}
