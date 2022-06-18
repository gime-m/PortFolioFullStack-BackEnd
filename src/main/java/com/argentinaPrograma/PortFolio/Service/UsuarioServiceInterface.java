package com.argentinaPrograma.PortFolio.Service;

import com.argentinaPrograma.PortFolio.Model.Rol;
import com.argentinaPrograma.PortFolio.Model.Usuario;
import java.util.List;

public interface UsuarioServiceInterface {
    Usuario guardarUsuario (Usuario user);
    Rol guardarRol (Rol rol);
    void rolAUsuario (String username,String rolname);
    Usuario getUsuario (String username);
    List<Usuario> getUsuarios ();
}
