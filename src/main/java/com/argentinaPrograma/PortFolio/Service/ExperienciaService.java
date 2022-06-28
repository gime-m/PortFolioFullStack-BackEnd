package com.argentinaPrograma.PortFolio.Service;

import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.GetPutExperiencia;
import com.argentinaPrograma.PortFolio.DTO.PostDTO.PostExperiencia;
import com.argentinaPrograma.PortFolio.Model.Experiencia;
import com.argentinaPrograma.PortFolio.Repository.ExperienciaRepository;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService extends AbstractImageService <Experiencia, GetPutExperiencia, PostExperiencia, ExperienciaRepository> implements ExperienciaServiceInterface{
}
