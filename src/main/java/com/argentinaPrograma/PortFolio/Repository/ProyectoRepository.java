package com.argentinaPrograma.PortFolio.Repository;

import com.argentinaPrograma.PortFolio.Model.Proyecto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends AbstractRepository <Proyecto>{
    
    @Query(value = "SELECT * FROM proyecto WHERE persona_id = ?1", nativeQuery = true)
    @Override
    List<Proyecto> findAllByPersonaId(Long personaId);
}