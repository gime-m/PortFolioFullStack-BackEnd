package com.argentinaPrograma.PortFolio.Service;

import com.argentinaPrograma.PortFolio.DTO.GetPutPersona;
import com.argentinaPrograma.PortFolio.DTO.GetPutPersona2;
import com.argentinaPrograma.PortFolio.Model.Persona;
import com.argentinaPrograma.PortFolio.Repository.PersonaRepository;
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
    public List<Persona> verTodo() {
        return persRepo.findAll();
    }

    @Override
    public Optional<Persona> buscarElemento(Long id) {
        return persRepo.findById(id);
    }

    @Override
    public void editarElemento(GetPutPersona pers) {
        Persona obj = persRepo.findById(pers.getId()).get();
        Persona objCambios = modelMapper.map(pers, Persona.class);
        modelMapper.map(objCambios, obj);
        persRepo.save(obj);      
    }
    
    @Override
    public Persona crearElemento (Persona pers) {
        return persRepo.save(pers);
    }
    
    @Override
    public <T extends GetPutPersona2> void editarPersona(T pers) {
        Persona obj = persRepo.findById(pers.getId()).get();
        modelMapper.map(pers, obj);
        persRepo.save(obj);      
    }

    /*
    @Override
    public void borrarElemento(Long id) {
        persRepo.deleteById(id);
    }
    */
}
