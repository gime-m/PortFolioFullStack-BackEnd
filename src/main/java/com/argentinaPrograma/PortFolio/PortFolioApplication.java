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

           //Roles y usuarios
           userServ.guardarRol(new Rol(null ,"ADMIN"));
           userServ.guardarRol(new Rol(null ,"USER"));
           
           userServ.guardarUsuario(new Usuario(null, "GimenaMartin", "gimenamartin144", "Gimena Martín", new ArrayList<>()));
           userServ.guardarUsuario(new Usuario(null, "Invitado", "1234", "Invitado", new ArrayList<>()));
           
           userServ.rolAUsuario("GimenaMartin", "ADMIN");
           userServ.rolAUsuario("Invitado", "USER");
           
           //Persona
           persServ.crearElemento(new Persona(null, "Gimena", "Martín Girardi", "Estudiante de astronomía", "Soy estudiante de astronomía, en la UNSJ en San Juan. Actualmente estoy cursando mi último año, y participo en proyectos de investigación enfocados en el estudio de estrellas con presencia de exoplanetas.","Rivadavia, San Juan", "FCEFN - UNSJ", "gimenamartin@hotmail.com", "+54 264 459 0668", "", "", "github.com/gime-m", new HashSet<>(), new HashSet<>(), new HashSet<>(), new HashSet<>()));
 
           //Experiencia
           expServ.crearElemento(new PostExperiencia("Becaria EVC-CIN: Correlación planeta-metalicidad", "Estudio de correlación planeta-metalicidad en estrellas de tipos espectrales tempranos, mediante el uso de SYNTHE y ATLAS12", "FCEFN - UNSJ", new java.sql.Date(new SimpleDateFormat("yyyyMMdd").parse("2021-08-01").getTime()), null, true, "", 1));
           expServ.crearElemento(new PostExperiencia("Auxiliar docente en el área de física", "Axiliar alumno en la cátedra Física I, colaborando con las correcciones de evaluaciones y la solución de consultas de alumnos.", "FCEFN - UNSJ", new java.sql.Date(new SimpleDateFormat("yyyyMMdd").parse("2020-04-01").getTime()), null, true, "", 1));
           
           //Educacion
           edServ.crearElemento(new PostEducacion ("En curso:Licenciatura en astronomía", "Estudios en cálculo, álgebra, computación y física, orientado al análisis de cuerpos celestes.", "FCEFN - UNSJ", new java.sql.Date(new SimpleDateFormat("yyyyMMdd").parse("2018-03-01").getTime()), null, true, "", (1) ));
           edServ.crearElemento(new PostEducacion ("Argentina Programa: Fase 1", "Introducción a la programación", "", new java.sql.Date(new SimpleDateFormat("yyyyMMdd").parse("2020-01-01").getTime()), null, false, "", 1 ));
           edServ.crearElemento(new PostEducacion ("Capacitación en inglés", "", "Instituto privado Saint Thomas, San Juan", new java.sql.Date(new SimpleDateFormat("yyyyMMdd").parse("2021-12-01").getTime()), null, true, "", 1 ));
           
           //Skill
           skServ.crearElemento(new PostSkill ("FORTRAN", 8, "hard", 1));
           skServ.crearElemento(new PostSkill ("HTML", 7, "hard", 1));
           skServ.crearElemento(new PostSkill ("CSS", 6, "hard", 1));
           skServ.crearElemento(new PostSkill ("TypeScript", 5, "hard", 1));
           skServ.crearElemento(new PostSkill ("Angular", 6, "hard", 1));
           
           skServ.crearElemento(new PostSkill ("Comunicación", 8, "soft", 1));
           skServ.crearElemento(new PostSkill ("Dedicación", 9, "soft", 1));
           
           skServ.crearElemento(new PostSkill ("Inglés", 9, "idioma", 1));
           skServ.crearElemento(new PostSkill ("Alemán", 3, "idioma", 1));
           
           //Proyectos
           
           proyServ.crearElemento(new PostProyecto ("Portfolio para Argentina Programa", "", null, "github.com", "", 1));
       };
    }
    */
     
}
