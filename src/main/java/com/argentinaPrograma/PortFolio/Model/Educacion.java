package com.argentinaPrograma.PortFolio.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@JsonIgnoreProperties("personaEduc")
@Entity
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO , generator = "EducacionGenerator")
    @SequenceGenerator(name="EducacionGenerator", sequenceName = "educacion_sequence")
    private Long id;
    
    @Column(nullable = false, length=100)
    private String titulo;
    
    @Column(length=250)
    private String descripcion;
    
    @Column(length=60)
    private String institucion;
    
    private Date fechaInicio;
    private Date fechaFin;
    private Boolean isCurrent;
    
    @Column(length=60)
    private String imagen;

    @Column(nullable = false)
    private int displayOrder;    
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Persona.class)
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona personaEduc; 
}
