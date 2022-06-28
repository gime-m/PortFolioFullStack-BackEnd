package com.argentinaPrograma.PortFolio.Controller;

import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.GetPutProyecto;
import com.argentinaPrograma.PortFolio.DTO.PostDTO.PostProyecto;
import com.argentinaPrograma.PortFolio.Model.Proyecto;
import com.argentinaPrograma.PortFolio.Service.ProyectoServiceInterface;
import javax.annotation.PostConstruct;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proy")
public class ProyectoController extends AbstractImageController<Proyecto, GetPutProyecto, PostProyecto, ProyectoServiceInterface>{
    
    @PostConstruct
    public void initialize() {
        this.claseGP = GetPutProyecto.class;
        this.claseTipo = Proyecto.class;
        this.folderName = "proyecto";
    }
}
