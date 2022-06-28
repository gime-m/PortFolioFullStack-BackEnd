package com.argentinaPrograma.PortFolio.Controller;

import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.GetPutSkill;
import com.argentinaPrograma.PortFolio.DTO.PostDTO.PostSkill;
import com.argentinaPrograma.PortFolio.Model.Skill;
import com.argentinaPrograma.PortFolio.Service.SkillServiceInterface;
import javax.annotation.PostConstruct;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/skill")
public class SkillController extends AbstractController<Skill, GetPutSkill, PostSkill, SkillServiceInterface>{
    
    @PostConstruct
    public void initialize() {
        this.claseGP = GetPutSkill.class;
        this.claseTipo = Skill.class;
    }
}