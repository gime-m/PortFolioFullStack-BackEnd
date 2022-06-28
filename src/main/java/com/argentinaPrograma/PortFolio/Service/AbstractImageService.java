package com.argentinaPrograma.PortFolio.Service;

import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.AbstractGetPut;
import com.argentinaPrograma.PortFolio.DTO.PostDTO.AbstractPost;
import com.argentinaPrograma.PortFolio.Model.AbstractImageModel;
import com.argentinaPrograma.PortFolio.Repository.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractImageService <Tipo extends AbstractImageModel, GetPut extends AbstractGetPut, Post extends AbstractPost, Rep extends AbstractRepository <Tipo>> extends AbstractService<Tipo,GetPut, Post,Rep> implements AbstractImageServiceInterface <Tipo,GetPut, Post>{
    
    @Autowired
    public Rep repository;
    
    public void cambiarImagen(Long id, String path) {
        Tipo item = repository.findById(id).get();
        item.setImagen(path);
        repository.save(item);
    }
}
