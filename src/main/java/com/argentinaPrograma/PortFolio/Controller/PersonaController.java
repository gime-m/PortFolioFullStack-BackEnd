package com.argentinaPrograma.PortFolio.Controller;

import com.argentinaPrograma.PortFolio.DTO.GetPutPersona;
import com.argentinaPrograma.PortFolio.Model.Persona;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.argentinaPrograma.PortFolio.Service.PersonaServiceInterface;

@RestController
public class PersonaController {
    
    @Autowired
    private PersonaServiceInterface persServ;
    
    @GetMapping ("/persona/ver/")
    @ResponseBody
    public List<Persona> verListaPersonas(){
        return persServ.verTodo();
    }
    
    @GetMapping ("/persona")
    @ResponseBody
    public Optional<Persona> verPersona(@RequestParam Long id){
        return persServ.buscarElemento(id);
    }
    
    @PutMapping("/persona/editar")
    public void EditarPersona(@RequestBody GetPutPersona pers){
        persServ.editarElemento(pers);
    }
    
    /*
    @PostMapping ("/persona/crear")
    public Persona crearPersona(@RequestBody Persona pers){
        return persServ.crearElemento(pers);
    }
    
    @DeleteMapping("/persona/eliminar")
    public void eliminarPersona(@RequestParam Long id){
        persServ.borrarElemento(id);
    }
    */
}