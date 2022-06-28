package com.argentinaPrograma.PortFolio.Repository;

import com.argentinaPrograma.PortFolio.Model.Experiencia;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends AbstractRepository <Experiencia>{
        
    @Query(value = "SELECT * FROM experiencia WHERE persona_id = ?1", nativeQuery = true)
    @Override
    List<Experiencia> findAllByPersonaId(Long personaId);
}
