package com.argentinaPrograma.PortFolio.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties("personaSkill")
@Entity
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO , generator = "SkillGenerator")
    @SequenceGenerator(name="SkillGenerator", sequenceName = "skill_sequence")
    private Long id;
    
    @Column(nullable = false, length=25)
    private String titulo;
    
    @Column(nullable = false)
    private int valor;
    
    @Column(nullable = false, length=10)
    private String tipo;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Persona.class)
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona personaSkill;
}
