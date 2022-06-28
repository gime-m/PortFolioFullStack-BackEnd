package com.argentinaPrograma.PortFolio.Repository;

import com.argentinaPrograma.PortFolio.Model.Educacion;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends AbstractRepository <Educacion> {
    
    @Query(value = "SELECT * FROM educacion WHERE persona_id = ?1", nativeQuery = true)
    @Override
    List<Educacion> findAllByPersonaId(Long personaId);
}
