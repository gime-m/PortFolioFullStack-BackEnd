package com.argentinaPrograma.PortFolio.Controller;

import com.argentinaPrograma.PortFolio.DTO.GetPutDTO.AbstractGetPut;
import com.argentinaPrograma.PortFolio.DTO.PostDTO.AbstractPost;
import com.argentinaPrograma.PortFolio.Model.AbstractImageModel;
import com.argentinaPrograma.PortFolio.Service.AbstractImageServiceInterface;
import com.argentinaPrograma.PortFolio.Service.ImagenServiceInterface;
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
import org.springframework.web.multipart.MultipartFile;

public abstract class AbstractImageController <Tipo extends AbstractImageModel, GetPut extends AbstractGetPut, Post extends AbstractPost, ServInt extends AbstractImageServiceInterface<Tipo, GetPut, Post>> extends AbstractController<Tipo, GetPut, Post, ServInt>{
    
    @Autowired
    private ServInt service;
    
    @Autowired
    private ImagenServiceInterface imgServ;
    
    String folderName;
    
    @DeleteMapping("/eliminar")
    @Override
    public void eliminar(@RequestParam Long id){
        super.eliminar(id);
        Path path = imgServ.getRootPath().resolve(folderName + "/imagen-" + id + ".png");
        imgServ.borrarImagen(path);
    }
    
    @GetMapping("/ver-imagen/{filename}")
    @ResponseBody
    public ResponseEntity<Resource> verImagen(@PathVariable String filename) {
        Resource file = imgServ.verImagen(folderName + "/" + filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
    
    @PutMapping("/subir-imagen/")
    public void subirImagen(@RequestParam Long id, @RequestParam MultipartFile file) {
        imgServ.subirImagen(file, id, folderName);
        service.cambiarImagen(id, "ver-imagen/imagen-" + id + ".png");
    }
    
    @DeleteMapping("/borrar-imagen/{id}")
    public void borrarImagen (@PathVariable Long id) {
        Path path = imgServ.getRootPath().resolve(folderName + "/imagen-" + id + ".png");
        imgServ.borrarImagen(path);
        service.cambiarImagen(id, "");
    }    
}
