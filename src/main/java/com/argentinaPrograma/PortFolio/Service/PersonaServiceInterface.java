
package com.argentinaPrograma.PortFolio.Service;

import com.argentinaPrograma.PortFolio.DTO.GetPutPersona;
import com.argentinaPrograma.PortFolio.Model.Persona;
import java.util.List;
import java.util.Optional;

public interface PersonaServiceInterface {
    public List<Persona> verTodo();
    public Persona crearElemento (Persona pers);
    //public void borrarElemento (Long id);
    public Optional<Persona> buscarElemento (Long id);
    public void editarElemento(GetPutPersona pers);
}
