package com.argentinaPrograma.PortFolio.Controller;

import com.argentinaPrograma.PortFolio.DTO.GetPutEducacion;
import com.argentinaPrograma.PortFolio.DTO.GetPutExperiencia;
import com.argentinaPrograma.PortFolio.DTO.GetPutProyecto;
import com.argentinaPrograma.PortFolio.Service.EducacionServiceInterface;
import com.argentinaPrograma.PortFolio.Service.ExperienciaServiceInterface;
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
import com.argentinaPrograma.PortFolio.Service.ImagenServiceInterface;
import com.argentinaPrograma.PortFolio.Service.ProyectoServiceInterface;

@RestController
public class ImagenItemController {
  
    @Autowired
    ImagenServiceInterface imgServ;
    
    @Autowired
    ExperienciaServiceInterface expServ;
    
    @Autowired
    EducacionServiceInterface educServ;
    
    @Autowired
    ProyectoServiceInterface proyServ;
    
    @GetMapping("/ver-imagen/experiencia/{filename}")
    @ResponseBody
    public ResponseEntity<Resource> verImagenExp(@PathVariable String filename) {
        Resource file = imgServ.verImagen("experiencia/"+filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
    
    @GetMapping("/ver-imagen/educacion/{filename}")
    @ResponseBody
    public ResponseEntity<Resource> verImagenEduc(@PathVariable String filename) {
        Resource file = imgServ.verImagen("educacion/"+filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
    
    @GetMapping("/ver-imagen/proyecto/{filename}")
    @ResponseBody
    public ResponseEntity<Resource> verImagenProy(@PathVariable String filename) {
        Resource file = imgServ.verImagen("proyecto/"+filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PutMapping("/subir-imagen/exp")
    public void subirImagenExperiencia(@RequestParam Long id, @RequestParam MultipartFile file) {
        imgServ.subirImagen(file, id, "experiencia");
        GetPutExperiencia exp = expServ.buscarElemento(id);
        exp.setImagen("ver-imagen/experiencia/imagen-" + id + ".png");
        expServ.editarElemento(exp);
    }
    
    @PutMapping("/subir-imagen/educ")
    public void subirImagenEducacion(@RequestParam Long id, @RequestParam MultipartFile file) {
        imgServ.subirImagen(file, id, "educacion");
        GetPutEducacion educ = educServ.buscarElemento(id);
        educ.setImagen("ver-imagen/educacion/imagen-" + id + ".png");
        educServ.editarElemento(educ);
    }
    
    @PutMapping("/subir-imagen/proy")
    public void subirImagenProyecto(@RequestParam Long id, @RequestParam MultipartFile file) {
        imgServ.subirImagen(file, id, "proyecto");
        GetPutProyecto proy = proyServ.buscarElemento(id);
        proy.setImagen("ver-imagen/proyecto/imagen-" + id + ".png");
        proyServ.editarElemento(proy);
    }
    
    
    @DeleteMapping("borrar-imagen/exp/{id}")
    public void borrarImagenExperiencia (@PathVariable Long id) {
        GetPutExperiencia exp = expServ.buscarElemento(id);
        Path path = imgServ.getRootPath().resolve("experiencia/imagen-" + id + ".png");
        imgServ.borrarImagen(path);
        exp.setImagen("");
        expServ.editarElemento(exp);
    }
    
    @DeleteMapping("borrar-imagen/educ/{id}")
    public void borrarImagenEducacion (@PathVariable Long id) {
        GetPutEducacion educ = educServ.buscarElemento(id);
        Path path = imgServ.getRootPath().resolve("educacion/imagen-" + id + ".png");
        imgServ.borrarImagen(path);
        educ.setImagen("");
        educServ.editarElemento(educ);
    }
    
    @DeleteMapping("borrar-imagen/proy/{id}")
    public void borrarImagenProyecto (@PathVariable Long id) {
        GetPutProyecto proy = proyServ.buscarElemento(id);
        Path path = imgServ.getRootPath().resolve("proyecto/imagen-" + id + ".png");
        imgServ.borrarImagen(path);
        proy.setImagen("");
        proyServ.editarElemento(proy);
    }
    

    /*   
    
    @GetMapping("/imagens/exp")
    @ResponseBody
    public Resource[] verImagensExperiencia() {
         return imgServ.verImagenes("experiencia"); 
    }
    
    @GetMapping("/imagens/educ")
    @ResponseBody
    public Resource[] verImagensEducacion() {
         return imgServ.verImagenes("educacion"); 
    }  
    
    @PostMapping("/subir-imagen")
    public void uploadFile(@RequestParam Long id, @RequestParam MultipartFile file) {
        String message;
        try {
            storServ.save(file, id);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }*/
}

