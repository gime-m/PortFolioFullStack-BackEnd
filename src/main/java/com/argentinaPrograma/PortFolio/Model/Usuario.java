package com.argentinaPrograma.PortFolio.Model;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import static javax.persistence.FetchType.*;
import lombok.NoArgsConstructor;

@Getter @Setter
@NoArgsConstructor 
@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO , generator = "UsuarioGenerator")
    @SequenceGenerator(name="UsuarioGenerator", sequenceName = "user_sequence")
    private Long id;
    
    @Column(nullable = false, length=30)
    private String username;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false, length=30)
    private String nombre;
    
    @ManyToMany(fetch=EAGER)
    private Collection<Rol> roles = new ArrayList<>();
    
    public Usuario(Long id, String usrn, String password, String nom, Collection<Rol> rol){
        this.roles = new ArrayList<>();
        this.id=id;
        this.username=usrn;
        this.password=password;
        this.nombre=nom;
        this.roles = rol;
    }
}
