package com.argentinaPrograma.PortFolio.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor 
@Entity
public class Rol {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO , generator = "RolGenerator")
    @SequenceGenerator(name="RolGenerator", sequenceName = "rol_sequence")
    private Long id;
    
    @Column(nullable = false, length=10)
    private String nombre;
}
