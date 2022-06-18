package com.argentinaPrograma.PortFolio.Controller;

import com.argentinaPrograma.PortFolio.DTO.GetPutSkill;
import com.argentinaPrograma.PortFolio.DTO.PostSkill;
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
import com.argentinaPrograma.PortFolio.Service.SkillServiceInterface;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class SkillController {
    
    @Autowired
    private SkillServiceInterface skServ;
    
    
    @GetMapping ("/skill/ver/{idPersona}")
    @ResponseBody
    public List<GetPutSkill> verListaSkill(@PathVariable Long idPersona){
        return skServ.verTodoPorPersona(idPersona);
    }
    
    @PostMapping ("/skill/crear")
    public GetPutSkill crearSkill(@RequestBody PostSkill skill){
        return skServ.crearElemento(skill);
    }
    
    @GetMapping ("/skill/ver")
    @ResponseBody
    public GetPutSkill verSkill(@RequestParam Long id){
        return skServ.buscarElemento(id);
    }
    
    @DeleteMapping("/skill/eliminar")
    public void eliminarSkill(@RequestParam Long id){
        skServ.borrarElemento(id);
    }
    
    @PutMapping("/skill/editar")
    public void EditarSkill(@RequestBody GetPutSkill skill){
        skServ.editarElemento(skill);
    }

}
