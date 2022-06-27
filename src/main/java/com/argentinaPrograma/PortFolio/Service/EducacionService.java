package com.argentinaPrograma.PortFolio.Service;

import com.argentinaPrograma.PortFolio.DTO.DisplayOrder;
import com.argentinaPrograma.PortFolio.DTO.GetPutEducacion;
import com.argentinaPrograma.PortFolio.DTO.PostEducacion;
import com.argentinaPrograma.PortFolio.Model.Educacion;
import com.argentinaPrograma.PortFolio.Repository.EducacionRepository;
import com.argentinaPrograma.PortFolio.Repository.PersonaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements EducacionServiceInterface{
    
    @Autowired
    public EducacionRepository eduRepo;
    
    @Autowired
    public PersonaRepository persRepo;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public List<GetPutEducacion> verTodoPorPersona(Long personaId) {
        List<Educacion> items = eduRepo.findAllByPersonaId(personaId);
        List<GetPutEducacion> dto = new ArrayList<>();
        for(int i=0; i<items.size(); i++){
            dto.add(i, modelMapper.map(items.get(i), GetPutEducacion.class));
        }
      return dto;
    }
    
    @Override
    public GetPutEducacion crearElemento (PostEducacion edu) {  
        Educacion item = modelMapper.map(edu, Educacion.class);
        item.setId(null);
        item.setPersonaEduc(persRepo.getById(edu.getPersonaId()));
        Educacion itemGuardado = eduRepo.save(item);
        return modelMapper.map(itemGuardado, GetPutEducacion.class); 
    }
    
    @Override
    public void borrarElemento(Long id) {
        eduRepo.deleteById(id);
    }
    
    @Override
    public GetPutEducacion buscarElemento(Long id) {
        Optional<Educacion> item = eduRepo.findById(id);
        return modelMapper.map(item.get(), GetPutEducacion.class);      
    }
    
    @Override
    public void editarElemento(GetPutEducacion edu) {
        Educacion item = modelMapper.map(edu, Educacion.class);
        item.setPersonaEduc(persRepo.getById(edu.getPersonaId()));
        eduRepo.save(item);
    }
    
    @Override
    public void editarOrden(List<DisplayOrder> order) {
        Educacion item;
        for (DisplayOrder i : order){
             item = eduRepo.findById(i.getId()).get();
             item.setDisplayOrder(i.getDisplayOrder());
             eduRepo.save(item);
        }
    }
}
