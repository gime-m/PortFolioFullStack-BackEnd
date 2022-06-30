package com.argentinaPrograma.PortFolio.Service;

import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.GetPutPersona;
import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.IdPersona;
import com.argentinaPrograma.PortFolio.Model.Persona;
import com.argentinaPrograma.PortFolio.Repository.PersonaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements PersonaServiceInterface{

    @Autowired
    public PersonaRepository persRepo;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public List<GetPutPersona> verTodo() {
        //return persRepo.findAll();
        List<Persona> items = persRepo.findAll();
        List<GetPutPersona> dto = new ArrayList<>();
        for(int i=0; i<items.size(); i++){
            dto.add(i, modelMapper.map(items.get(i), GetPutPersona.class));
        }
      return dto;
    }

    @Override
    public GetPutPersona buscarElemento(Long id) {
        //return persRepo.findById(id);
        Optional<Persona> item = persRepo.findById(id);
        return modelMapper.map(item.get(), GetPutPersona.class); 
    }

    @Override
    public Persona crearElemento (Persona pers) {
        return persRepo.save(pers);
    }
    
    @Override
    public <T extends IdPersona> void editarPersona(T pers) {
        Persona obj = persRepo.findById(pers.getId()).get();
        modelMapper.map(pers, obj);
        persRepo.save(obj);      
    }
    
    @Override
    public void editarImagenPerfil(Long id, String path) {
        Persona obj = persRepo.findById(id).get();
        obj.setImagenPerfil(path);
        persRepo.save(obj);      
    }
    
    @Override
    public void editarBanner(Long id, String path) {
        Persona obj = persRepo.findById(id).get();
        obj.setBanner(path);
        persRepo.save(obj);      
    }
    

    /*
    @Override
    public void borrarElemento(Long id) {
        persRepo.deleteById(id);
    }
    
    @Override
    public void editarElemento(GetPutPersona pers) {
        Persona obj = persRepo.findById(pers.getId()).get();
        Persona objCambios = modelMapper.map(pers, Persona.class);
        modelMapper.map(objCambios, obj);
        persRepo.save(obj);      
    }
    */
}
