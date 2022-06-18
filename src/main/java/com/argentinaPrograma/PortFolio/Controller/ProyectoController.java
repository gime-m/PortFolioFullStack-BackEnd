package com.argentinaPrograma.PortFolio.Controller;

import com.argentinaPrograma.PortFolio.DTO.GetPutProyecto;
import com.argentinaPrograma.PortFolio.DTO.PostProyecto;
import com.argentinaPrograma.PortFolio.Service.ImagenServiceInterface;
import com.argentinaPrograma.PortFolio.Service.ProyectoServiceInterface;
import java.nio.file.Path;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProyectoController {
    
    @Autowired
    private ProyectoServiceInterface proyServ;
    
    @Autowired
    private ImagenServiceInterface imgServ;
    
    @GetMapping ("/proy/ver/{idPersona}")
    @ResponseBody
    public List<GetPutProyecto> verListaProyecto(@PathVariable Long idPersona){
        return proyServ.verTodoPorPersona(idPersona);
    }
    
    @PostMapping ("/proy/crear")
    public GetPutProyecto crearProyecto(@RequestBody PostProyecto ed){
        return proyServ.crearElemento(ed);
    }
    
    @GetMapping ("/proy/ver")
    @ResponseBody
    public GetPutProyecto verProyecto(@RequestParam Long id){
        return proyServ.buscarElemento(id);
    }
    
    @DeleteMapping("/proy/eliminar")
    public void eliminarProyecto(@RequestParam Long id){
        proyServ.borrarElemento(id);
        Path path = imgServ.getRootPath().resolve("proyecto/imagen-" + id + ".png");
        imgServ.borrarImagen(path);
    }
    
    @PutMapping("/proy/editar")
    public void EditarProyecto(@RequestBody GetPutProyecto ed){
        proyServ.editarElemento(ed);
    }  
}

