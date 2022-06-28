package com.argentinaPrograma.PortFolio.Repository;

import com.argentinaPrograma.PortFolio.Model.Skill;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends AbstractRepository <Skill>{
    
    @Query(value = "SELECT * FROM skill WHERE persona_id = ?1", nativeQuery = true)
    @Override
    List<Skill> findAllByPersonaId(Long personaId);
}
