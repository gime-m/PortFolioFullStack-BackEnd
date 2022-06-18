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
@JsonIgnoreProperties("personaProy")
@Entity
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO , generator = "ProyectoGenerator")
    @SequenceGenerator(name="ProyectoGenerator", sequenceName = "proyecto_sequence")
    private Long id;
    
    @Column(length = 45, nullable=false)
    private String titulo;
    
    @Column(length = 250)
    private String descripcion;
    
    private Date fecha;
    
    @Column(length = 60)
    private String link;
    
    @Column(length = 60)
    private String imagen;    
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Persona.class)
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona personaProy; 
}