package com.argentinaPrograma.PortFolio.Service;

import com.argentinaPrograma.PortFolio.DTO.DisplayOrder;
import com.argentinaPrograma.PortFolio.DTO.GetPutExperiencia;
import com.argentinaPrograma.PortFolio.DTO.PostExperiencia;
import com.argentinaPrograma.PortFolio.Model.Experiencia;
import com.argentinaPrograma.PortFolio.Repository.ExperienciaRepository;
import com.argentinaPrograma.PortFolio.Repository.PersonaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements ExperienciaServiceInterface{
    
    @Autowired
    public ExperienciaRepository expRepo;
    
    @Autowired
    public PersonaRepository persRepo;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public List<GetPutExperiencia> verTodoPorPersona(Long personaId) {
        List<Experiencia> items = expRepo.findAllByPersonaId(personaId);
        List<GetPutExperiencia> dto = new ArrayList<>();
        for(int i=0; i<items.size(); i++){
            dto.add(i, modelMapper.map(items.get(i), GetPutExperiencia.class));
        }
      return dto;
    }

    @Override
    public GetPutExperiencia crearElemento (PostExperiencia exp) {
        Experiencia item = modelMapper.map(exp, Experiencia.class);
        item.setId(null);
        item.setPersonaExp(persRepo.getById(exp.getPersonaId()));
        Experiencia itemGuardado = expRepo.save(item);
        return modelMapper.map(itemGuardado, GetPutExperiencia.class);      
    }

    @Override
    public void borrarElemento(Long id) {
        expRepo.deleteById(id);
    }

    @Override
    public GetPutExperiencia buscarElemento(Long id) {
        Optional<Experiencia> item = expRepo.findById(id);
        return modelMapper.map(item.get(), GetPutExperiencia.class);      
    }

    @Override
    public void editarElemento(GetPutExperiencia edu) {
        Experiencia item = modelMapper.map(edu, Experiencia.class);
        item.setPersonaExp(persRepo.getById(edu.getPersonaId()));
        expRepo.save(item);
    }

    @Override
    public void editarOrden(List<DisplayOrder> order) {
        Experiencia item;
        for (DisplayOrder i : order){
             item = expRepo.findById(i.getId()).get();
             item.setDisplayOrder(i.getDisplayOrder());
             expRepo.save(item);
        }
    }
}
