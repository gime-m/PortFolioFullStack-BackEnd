package com.argentinaPrograma.PortFolio.Service;

import com.argentinaPrograma.PortFolio.DTO.DisplayOrder;
import com.argentinaPrograma.PortFolio.DTO.GetPutSkill;
import com.argentinaPrograma.PortFolio.DTO.PostSkill;
import com.argentinaPrograma.PortFolio.Model.Skill;
import com.argentinaPrograma.PortFolio.Repository.PersonaRepository;
import com.argentinaPrograma.PortFolio.Repository.SkillRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements SkillServiceInterface {
    
    @Autowired
    public SkillRepository skillRepo;
    
    @Autowired
    public PersonaRepository persRepo;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public List<GetPutSkill> verTodoPorPersona(Long personaId) {
        List<Skill> items = skillRepo.findAllByPersonaId(personaId);
        List<GetPutSkill> dto = new ArrayList<>();
        for(int i=0; i<items.size(); i++){
            dto.add(i, modelMapper.map(items.get(i), GetPutSkill.class));
        }
      return dto;
    }

    @Override
    public GetPutSkill crearElemento (PostSkill skill) {
        Skill item = modelMapper.map(skill, Skill.class);
        item.setId(null);
        item.setPersonaSkill(persRepo.getById(skill.getPersonaId()));
        Skill itemGuardado = skillRepo.save(item);
        return modelMapper.map(itemGuardado, GetPutSkill.class);      
    }

    @Override
    public void borrarElemento(Long id) {
        skillRepo.deleteById(id);
    }

    @Override
    public GetPutSkill buscarElemento(Long id) {
        Optional<Skill> item = skillRepo.findById(id);
        return modelMapper.map(item.get(), GetPutSkill.class);      
    }

    @Override
    public void editarElemento(GetPutSkill skill) {
        Skill item = modelMapper.map(skill, Skill.class);
        item.setPersonaSkill(persRepo.getById(skill.getPersonaId()));
        skillRepo.save(item);
    }
    
    @Override
    public void editarOrden(List<DisplayOrder> order) {
        Skill item;
        for (DisplayOrder i : order){
             item = skillRepo.findById(i.getId()).get();
             item.setDisplayOrder(i.getDisplayOrder());
             skillRepo.save(item);
        }
    }
    
}
