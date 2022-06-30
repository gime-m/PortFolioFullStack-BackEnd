
package com.argentinaPrograma.PortFolio.Service;

import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.GetPutPersona;
import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.IdPersona;
import com.argentinaPrograma.PortFolio.Model.Persona;
import java.util.List;

public interface PersonaServiceInterface {
    public List<GetPutPersona> verTodo();
    public Persona crearElemento (Persona pers);
    public GetPutPersona buscarElemento (Long id);
    public <T extends IdPersona> void editarPersona (T pers);
    public void editarImagenPerfil(Long id, String path);
    public void editarBanner(Long id, String path);
}
