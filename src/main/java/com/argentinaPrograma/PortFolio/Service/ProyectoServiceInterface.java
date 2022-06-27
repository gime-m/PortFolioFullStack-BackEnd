package com.argentinaPrograma.PortFolio.Service;

import com.argentinaPrograma.PortFolio.DTO.DisplayOrder;
import com.argentinaPrograma.PortFolio.DTO.GetPutProyecto;
import com.argentinaPrograma.PortFolio.DTO.PostProyecto;
import java.util.List;

public interface ProyectoServiceInterface {
    public List<GetPutProyecto> verTodoPorPersona(Long personaId);
    public GetPutProyecto crearElemento (PostProyecto edu);
    public void borrarElemento (Long id);
    public GetPutProyecto buscarElemento (Long id);
    public void editarElemento (GetPutProyecto edu);
    public void editarOrden (List<DisplayOrder> order);
}
