package com.argentinaPrograma.PortFolio.Controller;

import java.nio.file.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.argentinaPrograma.PortFolio.Service.PersonaServiceInterface;
import com.argentinaPrograma.PortFolio.Service.ImagenServiceInterface;

@RestController
public class ImagenPersonaController {
  
    @Autowired
    ImagenServiceInterface imgServ;
    
    @Autowired
    PersonaServiceInterface persServ;
    
    @GetMapping("/persona/ver-imagen/{filename}")
    @ResponseBody
    public ResponseEntity<Resource> verImagen(@PathVariable String filename) {
        Resource file = imgServ.verImagen(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
    
    @PutMapping("/persona/subir-imagen/perfil")
    public void subirImagenPefil(@RequestParam Long id, @RequestParam MultipartFile file) {
        imgServ.subirImagen(file, id, "imagenPerfil");
        persServ.editarImagenPerfil(id, "ver-imagen/imagen-perfil-"+id+".png");
    }
    
    @PutMapping("/persona/subir-imagen/banner")
    public void subirImagenBanner(@RequestParam Long id, @RequestParam MultipartFile file) {
        imgServ.subirImagen(file, id, "banner");
        persServ.editarBanner(id, "ver-imagen/imagen-banner-"+id+".png");
    }
    
    @PutMapping("/persona/subir-imagen/fondo")
    public void subirImagenFondo(@RequestParam Long id, @RequestParam MultipartFile file) {
        imgServ.subirImagen(file, id, "imagenFondo");
        persServ.editarImagenFondo(id, "ver-imagen/imagen-fondo-"+id+".png");
    }
    
    @DeleteMapping("/persona/borrar-imagen/perfil/{id}")
    public void borrarImagenPerfil (@PathVariable Long id) {
        Path path = imgServ.getRootPath().resolve("imagen-perfil-"+id+".png");
        imgServ.borrarImagen(path);
        persServ.editarImagenPerfil(id, "");
    }
    
    @DeleteMapping("/persona/borrar-imagen/banner/{id}")
    public void borrarImagenBanner (@PathVariable Long id) {
        Path path = imgServ.getRootPath().resolve("imagen-banner-"+id+".png");
        imgServ.borrarImagen(path);
        persServ.editarBanner(id, "");
    }
    
    @DeleteMapping("/persona/borrar-imagen/fondo/{id}")
    public void borrarImagenFondo (@PathVariable Long id) {
        Path path = imgServ.getRootPath().resolve("imagen-fondo-"+id+".png");
        imgServ.borrarImagen(path);
        persServ.editarImagenFondo(id, "");
    }
}

//https://www.bezkoder.com/spring-boot-file-upload/
