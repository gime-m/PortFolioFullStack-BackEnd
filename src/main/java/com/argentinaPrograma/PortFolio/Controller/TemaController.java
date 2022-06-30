
package com.argentinaPrograma.PortFolio.Controller;

import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.GetPutPersonaTema;
import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.GetTema;
import com.argentinaPrograma.PortFolio.Model.Tema;
import com.argentinaPrograma.PortFolio.Service.TemaServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemaController {
    
    @Autowired
    private TemaServiceInterface temaServ;
    
    @PutMapping("/tema/editar")
    public Tema editarTema(@RequestBody GetPutPersonaTema gpObj){
        return temaServ.cambiarTema(gpObj);
    }
    
    @GetMapping("/tema")
    public Tema verTema (@RequestParam Long id){
        return temaServ.buscarTema(id);
    }
    
    @GetMapping("/tema/lista")
    public List<GetTema> verTemasLista () {
        return temaServ.verTodosTema();
    }
}
