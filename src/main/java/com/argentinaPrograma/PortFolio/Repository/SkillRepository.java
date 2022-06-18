package com.argentinaPrograma.PortFolio.Repository;

import com.argentinaPrograma.PortFolio.Model.Skill;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository <Skill, Long>{
    
    @Query(value = "SELECT * FROM skill WHERE persona_id = ?1", nativeQuery = true)
    List<Skill> findAllByPersonaId(Long personaId);
}
