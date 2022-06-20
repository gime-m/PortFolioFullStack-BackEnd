package com.argentinaPrograma.PortFolio.Controller;

import com.argentinaPrograma.PortFolio.DTO.RolAUsuario;
import com.argentinaPrograma.PortFolio.Model.Rol;
import com.argentinaPrograma.PortFolio.Model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.argentinaPrograma.PortFolio.Service.UsuarioServiceInterface;

@RestController
public class AuthController {
    
    @Autowired
    private UsuarioServiceInterface userServ;
       
    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios() {
        return userServ.getUsuarios();
    }
    
    @PostMapping("/usuario/guardar")
    public Usuario guardarUsuario(@RequestBody Usuario user) {
        return userServ.guardarUsuario(user);
    }
    
    @PostMapping("/rol/guardar")
    public Rol guardarRol(@RequestBody Rol rol) {
        return userServ.guardarRol(rol);
    }
    
    @PostMapping("/usuario/rol/guardar")
    public void guardarRolAUsuario(@RequestBody RolAUsuario form) {
        userServ.rolAUsuario(form.username, form.nombreRol);
    }   

}