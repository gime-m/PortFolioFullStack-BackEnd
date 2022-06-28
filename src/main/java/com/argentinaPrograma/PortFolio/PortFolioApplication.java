package com.argentinaPrograma.PortFolio;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class PortFolioApplication{

    public static void main(String[] args) {
        SpringApplication.run(PortFolioApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    
    /*
    @Bean
    CommandLineRunner run(UsuarioServiceInterface userServ, PersonaServiceInterface persServ, ExperienciaServiceInterface expServ, EducacionServiceInterface edServ, SkillServiceInterface skServ, ProyectoServiceInterface proyServ) {
       return (String[] args) -> {
           
           //Persona
           persServ.crearElemento(Persona.builder()
                   .id(null)
                   .nombre("Gimena")
                   .apellido("Martín Girardi")
                   .ocupacion("Estudiante de astronomía")
                   .descripcion("Soy estudiante de astronomía, en la UNSJ en San Juan. Actualmente estoy cursando mi último año, y participo en proyectos de investigación enfocados en el estudio de estrellas con presencia de exoplanetas.")
                   .ubicacion("Rivadavia, San Juan")
                   .lugarTrabajo("FCEFN - UNSJ")
                   .email("gimenamartin@hotmail.com")
                   .telefono("+54 264 459 0668")
                   .github("github.com/gime-m")
                   .imagenPerfil("")
                   .banner("")
                   .experiencia(new HashSet<>())
                   .educacion(new HashSet<>())
                   .proyecto(new HashSet<>())
                   .skill(new HashSet<>())
                   .build());

           //Roles y usuarios
           userServ.guardarRol(Rol.builder()
                   .id(null)
                   .nombre("ADMIN")
                   .build());
           userServ.guardarRol(Rol.builder()
                   .id(null)
                   .nombre("USER")
                   .build()); 
           userServ.guardarUsuario(Usuario.builder()
                   .roles(new ArrayList<>())
                   .username("GimenaMartin")
                   .password("0000")
                   .nombre("Gimena Martín")
                   .id(null)
                   .build());
           userServ.guardarUsuario(Usuario.builder()
                   .roles(new ArrayList<>())
                   .username("Invitado")
                   .password("0000")
                   .nombre("Invitado")
                   .id(null)
                   .build());
           userServ.rolAUsuario("GimenaMartin", "ADMIN");
           userServ.rolAUsuario("Invitado", "USER");

           //Experiencia
           expServ.crearElemento(PostExperiencia.builder()
                   .titulo("Becaria EVC-CIN: Correlación planeta-metalicidad")
                   .personaId(1)
                   .displayOrder(1)
                   .descripcion("Estudio de correlación planeta-metalicidad en estrellas de tipos espectrales tempranos, mediante el uso de SYNTHE y ATLAS12")
                   .lugar("FCEFN - UNSJ")
                   .fechaInicio(new java.sql.Date(new SimpleDateFormat("yyyyMMdd").parse("2021-08-01").getTime()))
                   .fechaFin(null)
                   .isCurrent(Boolean.TRUE)
                   .imagen("")
                   .build(), Experiencia.class, GetPutExperiencia.class);
           expServ.crearElemento(PostExperiencia.builder()
                   .titulo("Auxiliar docente en el área de física")
                   .personaId(1)
                   .displayOrder(2)
                   .descripcion("Axiliar alumno en la cátedra Física I, colaborando con las correcciones de evaluaciones y la solución de consultas de alumnos.")
                   .lugar("FCEFN - UNSJ")
                   .fechaInicio(new java.sql.Date(new SimpleDateFormat("yyyyMMdd").parse("2020-04-01").getTime()))
                   .fechaFin(null)
                   .isCurrent(Boolean.TRUE)
                   .imagen("")
                   .build(), Experiencia.class, GetPutExperiencia.class);
           
           //Educacion
           edServ.crearElemento(PostEducacion.builder()
                   .titulo("En curso:Licenciatura en astronomía")
                   .personaId(1)
                   .displayOrder(1)
                   .descripcion("Estudios en cálculo, álgebra, computación y física, orientado al análisis de cuerpos celestes.")
                   .institucion("FCEFN - UNSJ")
                   .fechaInicio(new java.sql.Date(new SimpleDateFormat("yyyyMMdd").parse("2018-03-01").getTime()))
                   .fechaFin(null)
                   .isCurrent(Boolean.TRUE)
                   .imagen("")
                   .build(), Educacion.class, GetPutEducacion.class);
           edServ.crearElemento(PostEducacion.builder()
                   .titulo("Argentina Programa: Fase 1")
                   .personaId(1).displayOrder(2).descripcion("Introducción a la programación")
                   .institucion("")
                   .fechaInicio(new java.sql.Date(new SimpleDateFormat("yyyyMMdd").parse("2020-01-01").getTime()))
                   .fechaFin(null)
                   .isCurrent(Boolean.FALSE)
                   .imagen("")
                   .build(), Educacion.class, GetPutEducacion.class);
           edServ.crearElemento(PostEducacion.builder()
                   .titulo("Capacitación en inglés")
                   .personaId(1).displayOrder(3).descripcion("")
                   .institucion("Instituto privado Saint Thomas, San Juan")
                   .fechaInicio(new java.sql.Date(new SimpleDateFormat("yyyyMMdd").parse("2021-12-01").getTime()))
                   .fechaFin(null).isCurrent(Boolean.FALSE)
                   .imagen("")
                   .build(), Educacion.class, GetPutEducacion.class);
           
           //Skill
           skServ.crearElemento(PostSkill.builder()
                   .titulo("FORTRAN")
                   .personaId(1)
                   .displayOrder(1)
                   .valor(8)
                   .tipo("hard")
                   .build(), Skill.class, GetPutSkill.class);
           skServ.crearElemento(PostSkill.builder()
                   .titulo("HTML")
                   .personaId(1)
                   .displayOrder(2)
                   .valor(7)
                   .tipo("hard")
                   .build(), Skill.class, GetPutSkill.class);
           skServ.crearElemento(PostSkill.builder()
                   .titulo("CSS")
                   .personaId(1)
                   .displayOrder(3)
                   .valor(6)
                   .tipo("hard")
                   .build(), Skill.class, GetPutSkill.class);
           skServ.crearElemento(PostSkill.builder()
                   .titulo("TypeScript")
                   .personaId(1)
                   .displayOrder(4)
                   .valor(5)
                   .tipo("hard")
                   .build(), Skill.class, GetPutSkill.class);
           skServ.crearElemento(PostSkill.builder()
                   .titulo("Angular")
                   .personaId(1)
                   .displayOrder(5)
                   .valor(6)
                   .tipo("hard")
                   .build(), Skill.class, GetPutSkill.class);
           
           skServ.crearElemento(PostSkill.builder()
                   .titulo("Comunicación")
                   .personaId(1)
                   .displayOrder(1)
                   .valor(6)
                   .tipo("soft")
                   .build(), Skill.class, GetPutSkill.class);
           skServ.crearElemento(PostSkill.builder()
                   .titulo("Dedicación")
                   .personaId(1)
                   .displayOrder(2)
                   .valor(9)
                   .tipo("soft")
                   .build(), Skill.class, GetPutSkill.class);
           skServ.crearElemento(PostSkill.builder()
                   .titulo("Inglés")
                   .personaId(1)
                   .displayOrder(1)
                   .valor(9)
                   .tipo("idioma")
                   .build(), Skill.class, GetPutSkill.class);
           skServ.crearElemento(PostSkill.builder()
                   .titulo("Alemán")
                   .personaId(1)
                   .displayOrder(2)
                   .valor(3)
                   .tipo("idioma")
                   .build(), Skill.class, GetPutSkill.class);
           
           //Proyectos
           proyServ.crearElemento(PostProyecto.builder()
                   .titulo("Portfolio para Argentina Programa")
                   .personaId(1)
                   .displayOrder(1)
                   .descripcion("")
                   .fecha(null)
                   .link("github.com")
                   .imagen("")
                   .build(), Proyecto.class, GetPutProyecto.class);
       };
    }
    */
    
     
}
