package com.argentinaPrograma.PortFolio.Service;

import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.AbstractGetPut;
import com.argentinaPrograma.PortFolio.DTO.PostDTO.AbstractPost;
import com.argentinaPrograma.PortFolio.Model.AbstractImageModel;

public interface AbstractImageServiceInterface <Tipo extends AbstractImageModel, GetPut extends AbstractGetPut, Post extends AbstractPost> extends  AbstractServiceInterface <Tipo, GetPut, Post>{
     public void cambiarImagen(Long id, String path);
}
