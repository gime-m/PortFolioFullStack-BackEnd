package com.argentinaPrograma.PortFolio.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter @Setter
@NoArgsConstructor
@Entity
@SuperBuilder(toBuilder = true)
@JsonIgnoreProperties({"persona", "hibernateLazyInitializer", "handler"})
public class Tema implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 20)
    private String mainColor;
    
    @Column(nullable = false, length = 20)
    private String mainColorDark;
    
    @Column(nullable = false, length = 20)
    private String mainColorDarker;
    
    @Column(nullable = false, length = 20)
    private String mainColorLowOpacity;
    
    @Column(nullable = false, length = 20)
    private String shadowColor;
    
    @Column(nullable = false, length = 20)
    private String nombre;
    
    @OneToOne(mappedBy = "tema")
    private Persona persona;
}
