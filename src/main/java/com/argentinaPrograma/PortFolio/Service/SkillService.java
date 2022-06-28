package com.argentinaPrograma.PortFolio.Service;

import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.GetPutSkill;
import com.argentinaPrograma.PortFolio.DTO.PostDTO.PostSkill;
import com.argentinaPrograma.PortFolio.Model.Skill;
import com.argentinaPrograma.PortFolio.Repository.SkillRepository;
import org.springframework.stereotype.Service;

@Service
public class SkillService extends AbstractService <Skill, GetPutSkill, PostSkill, SkillRepository>  implements SkillServiceInterface {
 
}