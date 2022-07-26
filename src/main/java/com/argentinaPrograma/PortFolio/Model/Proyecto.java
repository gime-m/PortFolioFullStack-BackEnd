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
public class Proyecto extends AbstractImageModel implements Serializable{
     
    @Column(length = 45, nullable=false)
    private String titulo;
    
    @Column(length = 500,nullable = true)
    private String descripcion;
    
    @Column(nullable = true)
    private Date fecha;
    
    @Column(length = 150, nullable = true)
    private String link;

}