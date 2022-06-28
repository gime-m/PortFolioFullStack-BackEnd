package com.argentinaPrograma.PortFolio.Controller;

import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.GetPutExperiencia;
import com.argentinaPrograma.PortFolio.DTO.PostDTO.PostExperiencia;
import com.argentinaPrograma.PortFolio.Model.Experiencia;
import org.springframework.web.bind.annotation.RestController;
import com.argentinaPrograma.PortFolio.Service.ExperienciaServiceInterface;
import javax.annotation.PostConstruct;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/exp")
public class ExperienciaController extends AbstractImageController<Experiencia, GetPutExperiencia, PostExperiencia, ExperienciaServiceInterface>{
    
    @PostConstruct
    public void initialize() {
        this.claseGP = GetPutExperiencia.class;
        this.claseTipo = Experiencia.class;
        this.folderName = "experiencia";
    }
}