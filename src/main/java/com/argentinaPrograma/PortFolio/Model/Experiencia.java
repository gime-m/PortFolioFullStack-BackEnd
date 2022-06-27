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

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties("personaExp")
@Entity
public class Experiencia {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO , generator = "ExperienciaGenerator")
    @SequenceGenerator(name="ExperienciaGenerator", sequenceName = "experiencia_sequence")
    private Long id;
    
    @Column(nullable = false, length=60)
    private String titulo;
    
    @Column(length=250)
    private String descripcion;
    
    @Column(length=50)
    private String lugar;
    
    private Date fechaInicio;
    private Date fechaFin;
    private Boolean isCurrent;
    
    @Column(nullable = false)
    private int displayOrder;
    
    @Column(nullable = false, length=60)
    private String imagen;    
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Persona.class)
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona personaExp;
}
