package com.argentinaPrograma.PortFolio.Service;

import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.DisplayOrder;
import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.AbstractGetPut;
import com.argentinaPrograma.PortFolio.DTO.PostDTO.AbstractPost;
import com.argentinaPrograma.PortFolio.Model.AbstractModel;
import java.util.List;

public interface AbstractServiceInterface <Tipo extends AbstractModel, GetPut extends AbstractGetPut, Post extends AbstractPost> {
    public List<GetPut> verTodoPorPersona(Long personaId, Class<GetPut> clase);
    public GetPut crearElemento (Post postObject, Class<Tipo> claseTipo, Class<GetPut> claseGP);
    public void borrarElemento (Long id);
    public GetPut buscarElemento (Long id, Class<GetPut> claseGP);
    public void editarElemento (GetPut gpObject, Class<Tipo> claseTipo);
    public void editarOrden (List<DisplayOrder> order);
}
