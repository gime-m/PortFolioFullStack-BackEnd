package com.argentinaPrograma.PortFolio.Controller;

import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.GetPutEducacion;
import com.argentinaPrograma.PortFolio.DTO.PostDTO.PostEducacion;
import com.argentinaPrograma.PortFolio.Model.Educacion;
import org.springframework.web.bind.annotation.RestController;
import com.argentinaPrograma.PortFolio.Service.EducacionServiceInterface;
import javax.annotation.PostConstruct;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/educ")
public class EducacionController extends AbstractImageController<Educacion, GetPutEducacion, PostEducacion, EducacionServiceInterface>{
    
    @PostConstruct
    public void initialize() {
        this.claseGP = GetPutEducacion.class;
        this.claseTipo = Educacion.class;
        this.folderName = "educacion";
    }
}
