package com.argentinaPrograma.PortFolio.Service;

import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.DisplayOrder;
import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.AbstractGetPut;
import com.argentinaPrograma.PortFolio.DTO.PostDTO.AbstractPost;
import com.argentinaPrograma.PortFolio.Model.AbstractModel;
import com.argentinaPrograma.PortFolio.Repository.PersonaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.argentinaPrograma.PortFolio.Repository.AbstractRepository;
 
public abstract class AbstractService <Tipo extends AbstractModel, GetPut extends AbstractGetPut, Post extends AbstractPost, Rep extends AbstractRepository <Tipo>> implements AbstractServiceInterface <Tipo,GetPut, Post> {
    
    @Autowired
    public Rep repository;
    
    @Autowired
    public PersonaRepository persRepo;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public List<GetPut> verTodoPorPersona(Long personaId, Class<GetPut> claseGP) {
        List<Tipo> items = repository.findAllByPersonaId(personaId);
        List<GetPut> dto = new ArrayList<>();
        for(int i=0; i<items.size(); i++){
            dto.add(i, modelMapper.map(items.get(i), claseGP));
        }
      return dto;
    }

    @Override
    public GetPut crearElemento (Post postObject, Class<Tipo> claseTipo, Class<GetPut> claseGP) {
        Tipo item = modelMapper.map(postObject, claseTipo);
        item.setId(null);
        item.setPersona(persRepo.getById(postObject.getPersonaId()));
        Tipo itemGuardado = repository.save(item);
        return modelMapper.map(itemGuardado, claseGP);      
    }

    @Override
    public void borrarElemento(Long id) {
        repository.deleteById(id);
    }

    @Override
    public GetPut buscarElemento(Long id, Class<GetPut> claseGP) {
        Optional<Tipo> item = repository.findById(id);
        return modelMapper.map(item.get(), claseGP);      
    }

    @Override
    public void editarElemento(GetPut gpObject,Class<Tipo> claseTipo) {
        Tipo item = modelMapper.map(gpObject, claseTipo);
        item.setPersona(persRepo.getById(gpObject.getPersonaId()));
        repository.save(item);
    }

    @Override
    public void editarOrden(List<DisplayOrder> order) {
        Tipo item;
        for (DisplayOrder i : order){
             item = repository.findById(i.getId()).get();
             item.setDisplayOrder(i.getDisplayOrder());
             repository.save(item);
        }
    }
}

