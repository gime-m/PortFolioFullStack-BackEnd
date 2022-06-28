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
    
    @GetMapping("/ver-imagen/{filename}")
    @ResponseBody
    public ResponseEntity<Resource> verImagen(@PathVariable String filename) {
        Resource file = imgServ.verImagen(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
    
    @PutMapping("/subir-imagen/perfil")
    public void subirImagenPefil(@RequestParam Long id, @RequestParam MultipartFile file) {
        imgServ.subirImagen(file, id, "imagenPerfil");
        persServ.editarImagenPerfil(id, "ver-imagen/imagen-perfil-"+id+".png");
    }
    
    @PutMapping("/subir-imagen/banner")
    public void subirImagenBanner(@RequestParam Long id, @RequestParam MultipartFile file) {
        imgServ.subirImagen(file, id, "banner");
        persServ.editarBanner(id, "ver-imagen/imagen-banner-"+id+".png");
    }
    
    @DeleteMapping("borrar-imagen/perfil/{id}")
    public void borrarImagenPerfil (@PathVariable Long id) {
        Path path = imgServ.getRootPath().resolve("imagen-perfil-"+id+".png");
        imgServ.borrarImagen(path);
        persServ.editarImagenPerfil(id, "");
    }
    
    @DeleteMapping("borrar-imagen/banner/{id}")
    public void borrarImagenBanner (@PathVariable Long id) {
        Path path = imgServ.getRootPath().resolve("imagen-banner-"+id+".png");
        imgServ.borrarImagen(path);
        persServ.editarBanner(id, "");
    }
}

//https://www.bezkoder.com/spring-boot-file-upload/
