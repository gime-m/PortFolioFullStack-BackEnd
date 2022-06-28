package com.argentinaPrograma.PortFolio.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import static javax.persistence.FetchType.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter @Setter
@NoArgsConstructor 
@SuperBuilder
@Entity
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length=30)
    private String username;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false, length=30)
    private String nombre;
    
    @ManyToMany(fetch=EAGER)
    private Collection<Rol> roles = new ArrayList<>();
}
