package com.argentinaPrograma.PortFolio.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@JsonIgnoreProperties({"experiencia","educacion","skill","proyecto"})
@Entity
public class Persona implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length=25)
    private String nombre;
    
    @Column(nullable = false, length=25)
    private String apellido;
    
    @Column(nullable = false, length=60)
    private String ocupacion;
    
    @Column(nullable = false, length=500)
    private String descripcion;
    
    @Column(nullable = false, length=60)
    private String ubicacion;
    
    @Column(nullable = false, length=60)
    private String lugarTrabajo;
    
    @Column(nullable = false, length=60)
    private String email;
    
    @Column(nullable = false, length=25)
    private String telefono;
    
    @Column(nullable = false, length=60)
    private String imagenPerfil;
    
    @Column(nullable = false, length=60)
    private String banner;
    
    @Column(nullable = false, length=60)
    private String github;
    
    @Builder.Default
    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, targetEntity = Experiencia.class, cascade = CascadeType.ALL)
    private Set<Experiencia> experiencia = new HashSet<Experiencia>();
    
    @Builder.Default
    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, targetEntity = Educacion.class, cascade = CascadeType.ALL)
    private Set<Educacion> educacion = new HashSet<Educacion>();
    
    @Builder.Default
    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, targetEntity = Skill.class, cascade = CascadeType.ALL)
    private Set<Skill> skill = new HashSet<Skill>();
    
    @Builder.Default
    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, targetEntity = Proyecto.class, cascade = CascadeType.ALL)
    private Set<Proyecto> proyecto = new HashSet<Proyecto>();
}
