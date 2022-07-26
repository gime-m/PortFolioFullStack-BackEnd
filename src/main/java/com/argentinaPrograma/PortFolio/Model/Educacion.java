package com.argentinaPrograma.PortFolio.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter @Setter
@Entity
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@JsonIgnoreProperties("persona")
public class Educacion extends AbstractImageModel implements Serializable{
        
    @Column(nullable = false, length=100)
    private String titulo;
    
    @Column(length=300, nullable = true)
    private String descripcion;
    
    @Column(length=60, nullable = true)
    private String institucion;
    
    @Column(nullable = true)
    private Date fechaInicio;
    
    @Column(nullable = true)
    private Date fechaFin;
    
    @Column(nullable = true)
    private Boolean isCurrent;
}
