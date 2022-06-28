package com.argentinaPrograma.PortFolio.Model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter @Setter
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder(toBuilder = true)
public abstract class AbstractModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private int displayOrder;    
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Persona.class)
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;
}
