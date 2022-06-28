package com.argentinaPrograma.PortFolio.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
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
public class Skill extends AbstractModel implements Serializable{
    
    @Column(nullable = false, length=25)
    private String titulo;
    
    @Column(nullable = false)
    private int valor;
    
    @Column(nullable = false, length=10)
    private String tipo;
}
