package com.argentinaPrograma.PortFolio;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/*
import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.GetPutEducacion;
import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.GetPutExperiencia;
import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.GetPutPersonaTema;
import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.GetPutProyecto;
import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.GetPutSkill;
import com.argentinaPrograma.PortFolio.DTO.PostDTO.PostEducacion;
import com.argentinaPrograma.PortFolio.DTO.PostDTO.PostExperiencia;
import com.argentinaPrograma.PortFolio.DTO.PostDTO.PostProyecto;
import com.argentinaPrograma.PortFolio.DTO.PostDTO.PostSkill;
import com.argentinaPrograma.PortFolio.Model.Educacion;
import com.argentinaPrograma.PortFolio.Model.Experiencia;
import com.argentinaPrograma.PortFolio.Model.Persona;
import com.argentinaPrograma.PortFolio.Model.Proyecto;
import com.argentinaPrograma.PortFolio.Model.Rol;
import com.argentinaPrograma.PortFolio.Model.Skill;
import com.argentinaPrograma.PortFolio.Model.Tema;
import com.argentinaPrograma.PortFolio.Model.Usuario;
import com.argentinaPrograma.PortFolio.Service.EducacionServiceInterface;
import com.argentinaPrograma.PortFolio.Service.ExperienciaServiceInterface;
import com.argentinaPrograma.PortFolio.Service.PersonaServiceInterface;
import com.argentinaPrograma.PortFolio.Service.ProyectoServiceInterface;
import com.argentinaPrograma.PortFolio.Service.SkillServiceInterface;
import com.argentinaPrograma.PortFolio.Service.TemaServiceInterface;
import com.argentinaPrograma.PortFolio.Service.UsuarioServiceInterface;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import org.springframework.boot.CommandLineRunner;
*/
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
    CommandLineRunner run(UsuarioServiceInterface userServ, PersonaServiceInterface persServ, ExperienciaServiceInterface expServ, EducacionServiceInterface edServ, SkillServiceInterface skServ, ProyectoServiceInterface proyServ, TemaServiceInterface temaServ) {
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
                   .telefono("+54 264 459 0657")
                   .github("gime-m")
                   .imagenPerfil("ver-imagen/imagen-perfil-1.png")
                   .banner("ver-imagen/imagen-banner-1.png")
                   .imagenFondo("ver-imagen/imagen-fondo-1.png")
                   .experiencia(new HashSet<>())
                   .educacion(new HashSet<>())
                   .proyecto(new HashSet<>())
                   .skill(new HashSet<>())
                   .tema(null)
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
                   .password("GMG-144")
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
                   .descripcion("Estudio de correlación planeta-metalicidad en estrellas de tipos espectrales tempranos. Se utilizó el programa ATLAS12 para la generación de modelos de atmósferas estelares, y el programa SYNTHE para laa estimación de abundancias químicas en 3 estrellas tempranas.")
                   .lugar("FCEFN - UNSJ")
                   .fechaInicio(new java.sql.Date(new SimpleDateFormat("yyyyMMdd").parse("2021-08-01").getTime()))
                   .fechaFin(new java.sql.Date(new SimpleDateFormat("yyyyMMdd").parse("2022-08-01").getTime()))
                   .isCurrent(Boolean.TRUE)
                   .imagen("ver-imagen/imagen-1.png")
                   .build(), Experiencia.class, GetPutExperiencia.class);
           expServ.crearElemento(PostExperiencia.builder()
                   .titulo("Auxiliar docente en el área de física")
                   .personaId(1)
                   .displayOrder(2)
                   .descripcion("Axiliar alumno en la cátedra Física I desde 2020, colaborando con la corrección de evaluaciones y la solución de consultas de alumnos.")
                   .lugar("FCEFN - UNSJ")
                   .fechaInicio(new java.sql.Date(new SimpleDateFormat("yyyyMMdd").parse("2020-04-01").getTime()))
                   .fechaFin(null)
                   .isCurrent(Boolean.TRUE)
                   .imagen("ver-imagen/imagen-2.png")
                   .build(), Experiencia.class, GetPutExperiencia.class);
           expServ.crearElemento(PostExperiencia.builder()
                   .titulo("Atención a turistas en Observatorio")
                   .personaId(1)
                   .displayOrder(3)
                   .descripcion("Colaboración con estudiantes y personal del observatorio, en la realización de visitas guiadas y observaciones nocturnas y solares.")
                   .lugar("Observatorio Astronómico Félix Aguilar")
                   .fechaInicio(new java.sql.Date(new SimpleDateFormat("yyyyMMdd").parse("2022-07-01").getTime()))
                   .fechaFin(null)
                   .isCurrent(Boolean.TRUE)
                   .imagen("ver-imagen/imagen-3.png")
                   .build(), Experiencia.class, GetPutExperiencia.class);
           
           //Educacion
           edServ.crearElemento(PostEducacion.builder()
                   .titulo("En curso: Licenciatura en astronomía")
                   .personaId(1)
                   .displayOrder(1)
                   .descripcion("Estudios en cálculo, álgebra, computación y física, orientado al análisis de cuerpos celestes.")
                   .institucion("FCEFN - UNSJ")
                   .fechaInicio(new java.sql.Date(new SimpleDateFormat("yyyyMMdd").parse("2018-03-01").getTime()))
                   .fechaFin(null)
                   .isCurrent(Boolean.TRUE)
                   .imagen("ver-imagen/imagen-1.png")
                   .build(), Educacion.class, GetPutEducacion.class);
           edServ.crearElemento(PostEducacion.builder()
                   .titulo("Argentina Programa: Fase 1")
                   .personaId(1)
                   .displayOrder(2)
                   .descripcion("Fundamentos básicos de la programación imperativa y orientada a objectos")
                   .institucion("")
                   .fechaInicio(new java.sql.Date(new SimpleDateFormat("yyyyMMdd").parse("2020-01-01").getTime()))
                   .fechaFin(null)
                   .isCurrent(Boolean.FALSE)
                   .imagen("ver-imagen/imagen-2.png")
                   .build(), Educacion.class, GetPutEducacion.class);
           edServ.crearElemento(PostEducacion.builder()
                   .titulo("Capacitación en inglés")
                   .personaId(1)
                   .displayOrder(3)
                   .descripcion("")
                   .institucion("Instituto privado Saint Thomas, San Juan")
                   .fechaInicio(new java.sql.Date(new SimpleDateFormat("yyyyMMdd").parse("2012-03-01").getTime()))
                   .fechaFin(new java.sql.Date(new SimpleDateFormat("yyyyMMdd").parse("2017-12-01").getTime()))
                   .isCurrent(Boolean.FALSE)
                   .imagen("ver-imagen/imagen-3.png")
                   .build(), Educacion.class, GetPutEducacion.class);
           edServ.crearElemento(PostEducacion.builder()
                   .titulo("Alemán A1")
                   .personaId(1)
                   .displayOrder(4)
                   .descripcion("Con examen Goethe-Zertifikat A1.")
                   .institucion("Fundación Instituto Alemán")
                   .fechaInicio(new java.sql.Date(new SimpleDateFormat("yyyyMMdd").parse("2020-03-01").getTime()))
                   .fechaFin(new java.sql.Date(new SimpleDateFormat("yyyyMMdd").parse("2021-03-01").getTime()))
                   .isCurrent(Boolean.FALSE)
                   .imagen("ver-imagen/imagen-4.png")
                   .build(), Educacion.class, GetPutEducacion.class);
           
           //Skill
           skServ.crearElemento(PostSkill.builder()
                   .titulo("HTML")
                   .personaId(1)
                   .displayOrder(1)
                   .valor(8)
                   .tipo("hard")
                   .build(), Skill.class, GetPutSkill.class);
           skServ.crearElemento(PostSkill.builder()
                   .titulo("CSS")
                   .personaId(1)
                   .displayOrder(2)
                   .valor(7)
                   .tipo("hard")
                   .build(), Skill.class, GetPutSkill.class);
           skServ.crearElemento(PostSkill.builder()
                   .titulo("TypeScript")
                   .personaId(1)
                   .displayOrder(3)
                   .valor(6)
                   .tipo("hard")
                   .build(), Skill.class, GetPutSkill.class);
           skServ.crearElemento(PostSkill.builder()
                   .titulo("Angular")
                   .personaId(1)
                   .displayOrder(4)
                   .valor(6)
                   .tipo("hard")
                   .build(), Skill.class, GetPutSkill.class);
           skServ.crearElemento(PostSkill.builder()
                   .titulo("Spring Boot")
                   .personaId(1)
                   .displayOrder(5)
                   .valor(7)
                   .tipo("hard")
                   .build(), Skill.class, GetPutSkill.class);
           skServ.crearElemento(PostSkill.builder()
                   .titulo("SQL")
                   .personaId(1)
                   .displayOrder(4)
                   .valor(7)
                   .tipo("hard")
                   .build(), Skill.class, GetPutSkill.class);
           skServ.crearElemento(PostSkill.builder()
                   .titulo("Python")
                   .personaId(1)
                   .displayOrder(7)
                   .valor(4)
                   .tipo("hard")
                   .build(), Skill.class, GetPutSkill.class);
           skServ.crearElemento(PostSkill.builder()
                   .titulo("FORTRAN")
                   .personaId(1)
                   .displayOrder(8)
                   .valor(8)
                   .tipo("hard")
                   .build(), Skill.class, GetPutSkill.class);
           
           skServ.crearElemento(PostSkill.builder()
                   .titulo("Comunicación")
                   .personaId(1)
                   .displayOrder(1)
                   .valor(9)
                   .tipo("soft")
                   .build(), Skill.class, GetPutSkill.class);
           skServ.crearElemento(PostSkill.builder()
                   .titulo("Resolución de problemas")
                   .personaId(1)
                   .displayOrder(2)
                   .valor(9)
                   .tipo("soft")
                   .build(), Skill.class, GetPutSkill.class);
           skServ.crearElemento(PostSkill.builder()
                   .titulo("Gestión de tiempo")
                   .personaId(1)
                   .displayOrder(3)
                   .valor(8)
                   .tipo("soft")
                   .build(), Skill.class, GetPutSkill.class);
           skServ.crearElemento(PostSkill.builder()
                   .titulo("Trabajo en equipo")
                   .personaId(1)
                   .displayOrder(5)
                   .valor(8)
                   .tipo("soft")
                   .build(), Skill.class, GetPutSkill.class);
           skServ.crearElemento(PostSkill.builder()
                   .titulo("Flexibilidad")
                   .personaId(1)
                   .displayOrder(6)
                   .valor(8)
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
                   .descripcion("PortFolio como trabajo final para la segunda etapa de Argentina Programa. \n "
                           + "\n"
                           + "Front End: https://github.com/gime-m/PortFolioFullStack-FrontEnd. \n "
                           + "\n"
                           + "Back End: https://github.com/gime-m/PortFolioFullStack-BackEnd")
                   .fecha(null)
                   .link("https://github.com/gime-m/PortFolioFullStack-FrontEnd")
                   .imagen("ver-imagen/imagen-1.png")
                   .build(), Proyecto.class, GetPutProyecto.class);

           //Temas
           temaServ.crearTema(Tema.builder()
                   .id(null)
                   .mainColor("218, 207, 141, 1")
                   .mainColorDark("151, 118, 81, 1")
                   .mainColorDarker("86, 74, 62, 1")
                   .mainColorLowOpacity("255, 246, 194, 0.633")
                   .shadowColor("158, 152, 118, 1")
                   .nombre("beige")
                   .build());
           temaServ.crearTema(Tema.builder()
                   .id(null)
                   .mainColor("255, 165, 222, 1")
                   .mainColorDark("186, 103, 130, 1")
                   .mainColorDarker("121, 57, 76, 1")
                   .mainColorLowOpacity("255, 190, 229, 0.711")
                   .shadowColor("218, 174, 200, 1")
                   .nombre("rosa")
                   .build()); 
           temaServ.crearTema(Tema.builder()
                   .id(null)
                   .mainColor("100, 198, 103, 1")
                   .mainColorDark("86, 122, 78, 1")
                   .mainColorDarker("28, 72, 27, 1")
                   .mainColorLowOpacity("161, 232, 145, 0.711")
                   .shadowColor("137, 210, 134, 1")
                   .nombre("verde")
                   .build());
           temaServ.crearTema(Tema.builder()
                   .id(null)
                   .mainColor("97, 226, 255, 1")
                   .mainColorDark("35, 142, 152, 11")
                   .mainColorDarker("3, 92, 97, 1")
                   .mainColorLowOpacity("160, 242, 255, 0.711")
                   .shadowColor("115, 197, 205, 1")
                   .nombre("azul")
                   .build());
            temaServ.crearTema(Tema.builder()
                   .id(null)
                   .mainColor("202, 155, 255, 1")
                   .mainColorDark("140, 85, 154, 1")
                   .mainColorDarker("72, 3, 97, 1")
                   .mainColorLowOpacity("234, 160, 255, 0.711")
                   .shadowColor("201, 115, 205, 1")
                   .nombre("lila")
                   .build());
            temaServ.crearTema(Tema.builder()
                   .id(null)
                   .mainColor("255, 169, 169, 1")
                   .mainColorDark("179, 50, 50, 1")
                   .mainColorDarker("86, 23, 23, 1")
                   .mainColorLowOpacity("255, 130, 130, 0.633")
                   .shadowColor("163, 78, 78, 1")
                   .nombre("rojo")
                   .build());  
            temaServ.crearTema(Tema.builder()
                   .id(null)
                   .mainColor("237, 149, 90, 1")
                   .mainColorDark("201, 87, 25, 1")
                   .mainColorDarker("121, 55, 17, 1")
                   .mainColorLowOpacity("217, 161, 131, 0.688")
                   .shadowColor("192, 98, 57")
                   .nombre("naranja")
                   .build());  
            temaServ.crearTema(Tema.builder()
                   .id(null)
                   .mainColor("222, 222, 222, 1")
                   .mainColorDark("106, 106, 106, 1")
                   .mainColorDarker("49, 49, 49, 1")
                   .mainColorLowOpacity("241, 241, 241, 0.688")
                   .shadowColor("218, 218, 218")
                   .nombre("gris")
                   .build()); 
    
           temaServ.cambiarTema(GetPutPersonaTema.builder()
                   .personaId(1)
                   .temaId(7)
                   .build());
       };
    }
    */
}