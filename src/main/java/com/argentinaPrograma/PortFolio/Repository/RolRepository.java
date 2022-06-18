package com.argentinaPrograma.PortFolio.Repository;

import com.argentinaPrograma.PortFolio.Model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository <Rol, Long>{
    Rol findByNombre (String nombre);  
}
