package com.argentinaPrograma.PortFolio.Controller;

import com.argentinaPrograma.PortFolio.DTO.DisplayOrder;
import com.argentinaPrograma.PortFolio.DTO.GetPutEducacion;
import com.argentinaPrograma.PortFolio.DTO.PostEducacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.argentinaPrograma.PortFolio.Service.EducacionServiceInterface;
import com.argentinaPrograma.PortFolio.Service.ImagenServiceInterface;
import java.nio.file.Path;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class EducacionController {
    
    @Autowired
    private EducacionServiceInterface edServ;
    
    @Autowired
    private ImagenServiceInterface imgServ;
    
    @GetMapping ("/educ/ver/{idPersona}")
    @ResponseBody
    public List<GetPutEducacion> verListaEducacion(@PathVariable Long idPersona){
        return edServ.verTodoPorPersona(idPersona);
    }
    
    @PostMapping ("/educ/crear")
    public GetPutEducacion crearEducacion(@RequestBody PostEducacion ed){
        return edServ.crearElemento(ed);
    }
    
    @GetMapping ("/educ/ver")
    @ResponseBody
    public GetPutEducacion verEducacion(@RequestParam Long id){
        return edServ.buscarElemento(id);
    }
    
    @DeleteMapping("/educ/eliminar")
    public void eliminarEducacion(@RequestParam Long id){
        edServ.borrarElemento(id);
        Path path = imgServ.getRootPath().resolve("educacion/imagen-" + id + ".png");
        imgServ.borrarImagen(path);
    }
    
    @PutMapping("/educ/editar")
    public void EditarEducacion(@RequestBody GetPutEducacion ed){
        edServ.editarElemento(ed);
    }
    
    @PutMapping("/educ/ordenar")
    public void OrdenarExperiencia(@RequestBody List<DisplayOrder> order){
        edServ.editarOrden(order);
    }
}
