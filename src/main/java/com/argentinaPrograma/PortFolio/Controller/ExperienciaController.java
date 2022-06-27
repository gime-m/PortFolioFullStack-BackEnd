package com.argentinaPrograma.PortFolio.Controller;

import com.argentinaPrograma.PortFolio.DTO.DisplayOrder;
import com.argentinaPrograma.PortFolio.DTO.GetPutExperiencia;
import com.argentinaPrograma.PortFolio.DTO.PostExperiencia;
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
import com.argentinaPrograma.PortFolio.Service.ExperienciaServiceInterface;
import com.argentinaPrograma.PortFolio.Service.ImagenServiceInterface;
import java.nio.file.Path;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ExperienciaController {
    
    @Autowired
    private ExperienciaServiceInterface expServ;
    
    @Autowired
    private ImagenServiceInterface imgServ;
    
    @GetMapping("/exp/ver/{idPersona}")
    @ResponseBody
    public List<GetPutExperiencia> verListaExperiencia(@PathVariable Long idPersona) {
        return expServ.verTodoPorPersona(idPersona);
    }
    
    @PostMapping ("/exp/crear")
    public GetPutExperiencia crearExperiencia(@RequestBody PostExperiencia exp){
        return expServ.crearElemento(exp);
    }
    
    @GetMapping ("/exp/ver")
    @ResponseBody
    public GetPutExperiencia verExperiencia(@RequestParam Long id){
        return expServ.buscarElemento(id);
    }
    
    @DeleteMapping("/exp/eliminar")
    public void eliminarExperiencia(@RequestParam Long id){
        expServ.borrarElemento(id);
        Path path = imgServ.getRootPath().resolve("experiencia/imagen-" + id + ".png");
        imgServ.borrarImagen(path);
    }
    
    @PutMapping("/exp/editar")
    public void EditarExperiencia(@RequestBody GetPutExperiencia exp){
        expServ.editarElemento(exp);
    }
    
    @PutMapping("/exp/ordenar")
    public void OrdenarExperiencia(@RequestBody List<DisplayOrder> order){
        expServ.editarOrden(order);
    }
}
