package com.argentinaPrograma.PortFolio.Service;

import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.GetPutPersonaTema;
import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.GetTema;
import com.argentinaPrograma.PortFolio.Model.Tema;
import java.util.List;

public interface TemaServiceInterface {
    public void crearTema(Tema tema);
    public Tema buscarTema(Long id);
    public Tema cambiarTema(GetPutPersonaTema gpObject);
    public List<GetTema> verTodosTema ();
}
