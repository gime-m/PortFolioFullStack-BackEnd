package com.argentinaPrograma.PortFolio.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractRepository <Tipo> extends JpaRepository <Tipo, Long>{
    List<Tipo> findAllByPersonaId(Long personaId);
}
    
