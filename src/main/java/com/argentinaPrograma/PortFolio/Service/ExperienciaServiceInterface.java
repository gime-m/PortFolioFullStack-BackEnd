package com.argentinaPrograma.PortFolio.Service;

import com.argentinaPrograma.PortFolio.DTO.DisplayOrder;
import com.argentinaPrograma.PortFolio.DTO.GetPutExperiencia;
import com.argentinaPrograma.PortFolio.DTO.PostExperiencia;
import java.util.List;

public interface ExperienciaServiceInterface {
    public List<GetPutExperiencia> verTodoPorPersona(Long personaId);
    public GetPutExperiencia crearElemento (PostExperiencia exp);
    public void borrarElemento (Long id);
    public GetPutExperiencia buscarElemento (Long id);
    public void editarElemento(GetPutExperiencia exp);
    public void editarOrden (List<DisplayOrder> order);
}
