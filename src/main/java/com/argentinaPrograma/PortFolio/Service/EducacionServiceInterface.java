package com.argentinaPrograma.PortFolio.Service;

import com.argentinaPrograma.PortFolio.DTO.GetPutEducacion;
import com.argentinaPrograma.PortFolio.DTO.PostEducacion;
import java.util.List;

public interface EducacionServiceInterface {
    public List<GetPutEducacion> verTodoPorPersona(Long personaId);
    public GetPutEducacion crearElemento (PostEducacion edu);
    public void borrarElemento (Long id);
    public GetPutEducacion buscarElemento (Long id);
    public void editarElemento (GetPutEducacion edu);
}
