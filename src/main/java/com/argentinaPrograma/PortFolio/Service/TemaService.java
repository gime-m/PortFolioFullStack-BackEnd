package com.argentinaPrograma.PortFolio.Service;

import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.GetPutPersonaTema;
import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.GetTema;
import com.argentinaPrograma.PortFolio.Model.Persona;
import com.argentinaPrograma.PortFolio.Model.Tema;
import com.argentinaPrograma.PortFolio.Repository.PersonaRepository;
import com.argentinaPrograma.PortFolio.Repository.TemaRepository;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemaService implements  TemaServiceInterface{
    
    @Autowired
    public TemaRepository temaRepo;
    
    @Autowired
    public PersonaRepository persRepo;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public void crearTema(Tema tema){
        temaRepo.save(tema);
    }
    
    @Override
    public Tema buscarTema(Long id){
        return temaRepo.getById(id);
    }
    
    @Override
    public Tema cambiarTema(GetPutPersonaTema gpObject){
        Persona pers = persRepo.findById(gpObject.getPersonaId()).get();
        Tema tema = temaRepo.findById(gpObject.getTemaId()).get();
        pers.setTema(tema);
        persRepo.save(pers);
        return tema;
    }
    
    @Override
    public List<GetTema> verTodosTema () {
        List<Tema> temas = temaRepo.findAll();
        List<GetTema> temasSimple = new ArrayList<>();;
        for(int i=0; i<temas.size(); i++){
            temasSimple.add(modelMapper.map(temas.get(i), GetTema.class));
        }
        return temasSimple;
        
    }
}

