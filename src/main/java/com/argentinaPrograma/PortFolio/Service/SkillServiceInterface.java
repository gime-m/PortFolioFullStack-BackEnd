package com.argentinaPrograma.PortFolio.Service;

import com.argentinaPrograma.PortFolio.DTO.GetPutSkill;
import com.argentinaPrograma.PortFolio.DTO.PostSkill;
import java.util.List;

public interface SkillServiceInterface {
    public List<GetPutSkill> verTodoPorPersona(Long personaId);
    public GetPutSkill crearElemento (PostSkill skill);
    public void borrarElemento (Long id);
    public GetPutSkill buscarElemento (Long id);
    public void editarElemento(GetPutSkill skill);
    
}
