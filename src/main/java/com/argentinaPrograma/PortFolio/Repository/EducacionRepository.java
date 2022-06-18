package com.argentinaPrograma.PortFolio.Repository;

import com.argentinaPrograma.PortFolio.Model.Educacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository <Educacion, Long>{
    
    @Query(value = "SELECT * FROM educacion WHERE persona_id = ?1", nativeQuery = true)
    List<Educacion> findAllByPersonaId(Long personaId);
}
