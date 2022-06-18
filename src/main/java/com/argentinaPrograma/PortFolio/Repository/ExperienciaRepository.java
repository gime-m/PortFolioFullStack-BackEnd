package com.argentinaPrograma.PortFolio.Repository;

import com.argentinaPrograma.PortFolio.Model.Experiencia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository <Experiencia, Long>{
        
    @Query(value = "SELECT * FROM experiencia WHERE persona_id = ?1", nativeQuery = true)
    List<Experiencia> findAllByPersonaId(Long personaId);
    
}
