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
public class Experiencia extends AbstractImageModel implements Serializable{
   
    @Column(nullable = false, length=60)
    private String titulo;
    
    @Column(length=250)
    private String descripcion;
    
    @Column(length=50)
    private String lugar;
    
    private Date fechaInicio;
    private Date fechaFin;
    private Boolean isCurrent; 
}
