package com.argentinaPrograma.PortFolio.Service;

import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.GetPutProyecto;
import com.argentinaPrograma.PortFolio.DTO.PostDTO.PostProyecto;
import com.argentinaPrograma.PortFolio.Model.Proyecto;
import com.argentinaPrograma.PortFolio.Repository.ProyectoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService extends AbstractImageService <Proyecto, GetPutProyecto, PostProyecto, ProyectoRepository> implements ProyectoServiceInterface{
}
