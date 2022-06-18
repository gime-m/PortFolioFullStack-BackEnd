package com.argentinaPrograma.PortFolio.Service;

//import java.nio.file.Path;
//import java.util.stream.Stream;
import java.nio.file.Path;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ImagenServiceInterface {
    
    public void subirImagen(MultipartFile file, Long id, String tipo);
    public Resource verImagen(String filename);
    public void borrarImagen(Path path);
    public Path getRootPath ();
    
    //public void init();
    //public void deleteAll();
    //public Stream<Path> loadAll();
}
    
