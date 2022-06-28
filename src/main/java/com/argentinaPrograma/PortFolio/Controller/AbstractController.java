package com.argentinaPrograma.PortFolio.Controller;

import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.DisplayOrder;
import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.AbstractGetPut;
import com.argentinaPrograma.PortFolio.DTO.PostDTO.AbstractPost;
import com.argentinaPrograma.PortFolio.Model.AbstractModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.argentinaPrograma.PortFolio.Service.AbstractServiceInterface;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class AbstractController <Tipo extends AbstractModel, GetPut extends AbstractGetPut, Post extends AbstractPost, ServInt extends AbstractServiceInterface<Tipo, GetPut, Post>> {  
    
    @Autowired
    private ServInt service;
    
    Class<GetPut> claseGP;
    Class<Tipo> claseTipo;

    @GetMapping ("/ver/{idPersona}")
    @ResponseBody
    public List<GetPut> verLista(@PathVariable Long idPersona){
        return service.verTodoPorPersona(idPersona, claseGP);
    }
    
    @GetMapping ("/ver")
    public GetPut ver(@RequestParam Long id){
        return service.buscarElemento(id, claseGP);
    }
    
    @PostMapping ("/crear")
    public GetPut crear(@RequestBody Post postObj){
        return service.crearElemento(postObj, claseTipo, claseGP);
    }
    
    @PutMapping("/editar")
    public void editar (@RequestBody GetPut gpObj){
        service.editarElemento(gpObj, claseTipo);
    }
    
    @PutMapping("/ordenar")
    public void ordenar (@RequestBody List<DisplayOrder> order){
        service.editarOrden(order);
    }
    
    @DeleteMapping("/eliminar")
    public void eliminar (@RequestParam Long id){
        service.borrarElemento(id);
    }
}
