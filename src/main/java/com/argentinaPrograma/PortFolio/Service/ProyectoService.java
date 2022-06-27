package com.argentinaPrograma.PortFolio.Service;

import com.argentinaPrograma.PortFolio.DTO.DisplayOrder;
import com.argentinaPrograma.PortFolio.DTO.GetPutProyecto;
import com.argentinaPrograma.PortFolio.DTO.PostProyecto;
import com.argentinaPrograma.PortFolio.Model.Proyecto;
import com.argentinaPrograma.PortFolio.Repository.ProyectoRepository;
import com.argentinaPrograma.PortFolio.Repository.PersonaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements ProyectoServiceInterface{
    
    @Autowired
    public ProyectoRepository proyRepo;
    
    @Autowired
    public PersonaRepository persRepo;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public List<GetPutProyecto> verTodoPorPersona(Long personaId) {
        List<Proyecto> items = proyRepo.findAllByPersonaId(personaId);
        List<GetPutProyecto> dto = new ArrayList<>();
        for(int i=0; i<items.size(); i++){
            dto.add(i, modelMapper.map(items.get(i), GetPutProyecto.class));
        }
      return dto;
    }
    
    @Override
    public GetPutProyecto crearElemento (PostProyecto proy) {  
        Proyecto item = modelMapper.map(proy, Proyecto.class);
        item.setId(null);
        item.setPersonaProy(persRepo.getById(proy.getPersonaId()));
        Proyecto itemGuardado = proyRepo.save(item);
        return modelMapper.map(itemGuardado, GetPutProyecto.class); 
    }
    
    @Override
    public void borrarElemento(Long id) {
        proyRepo.deleteById(id);
    }
    
    @Override
    public GetPutProyecto buscarElemento(Long id) {
        Optional<Proyecto> item = proyRepo.findById(id);
        return modelMapper.map(item.get(), GetPutProyecto.class);      
    }
    
    @Override
    public void editarElemento(GetPutProyecto proy) {
        Proyecto item = modelMapper.map(proy, Proyecto.class);
        item.setPersonaProy(persRepo.getById(proy.getPersonaId()));
        proyRepo.save(item);
    }
    
    @Override
    public void editarOrden(List<DisplayOrder> order) {
        Proyecto item;
        for (DisplayOrder i : order){
             item = proyRepo.findById(i.getId()).get();
             item.setDisplayOrder(i.getDisplayOrder());
             proyRepo.save(item);
        }
    }
}
