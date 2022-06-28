package com.argentinaPrograma.PortFolio.Service;

import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.GetPutEducacion;
import com.argentinaPrograma.PortFolio.DTO.PostDTO.PostEducacion;
import com.argentinaPrograma.PortFolio.Model.Educacion;
import com.argentinaPrograma.PortFolio.Repository.EducacionRepository;
import org.springframework.stereotype.Service;

@Service
public class EducacionService extends AbstractImageService <Educacion, GetPutEducacion, PostEducacion, EducacionRepository> implements EducacionServiceInterface{
}
