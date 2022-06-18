package com.argentinaPrograma.PortFolio.Controller;

import com.argentinaPrograma.PortFolio.DTO.GetPutPersona;
import com.argentinaPrograma.PortFolio.Model.Persona;
import java.nio.file.Path;
import java.util.Optional;
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
import org.modelmapper.ModelMapper;

@RestController
public class ImagenPersonaController {
  
    @Autowired
    ImagenServiceInterface imgServ;
    
    @Autowired
    PersonaServiceInterface persServ;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @GetMapping("/ver-imagen/{filename}")
    @ResponseBody
    public ResponseEntity<Resource> verImagen(@PathVariable String filename) {
        Resource file = imgServ.verImagen(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
    
    @PutMapping("/subir-imagen/perfil")
    public void subirImagenPefil(@RequestParam Long id, @RequestParam MultipartFile file) {
        imgServ.subirImagen(file, id, "imagenPerfil");
        Optional<Persona> pers = persServ.buscarElemento(id);
        pers.get().setImagenPerfil("ver-imagen/imagen-perfil-"+id+".png");
        GetPutPersona objCambios = modelMapper.map(pers.get(), GetPutPersona.class);
        persServ.editarElemento(objCambios);
    }
    
    @PutMapping("/subir-imagen/banner")
    public void subirImagenBanner(@RequestParam Long id, @RequestParam MultipartFile file) {
        imgServ.subirImagen(file, id, "banner");
        Optional<Persona> pers = persServ.buscarElemento(id);
        pers.get().setBanner("ver-imagen/imagen-banner-"+id+".png");
        GetPutPersona objCambios = modelMapper.map(pers.get(), GetPutPersona.class);
        persServ.editarElemento(objCambios);
    }
    
    @DeleteMapping("borrar-imagen/perfil/{id}")
    public void borrarImagenPerfil (@PathVariable Long id) {
        Optional<Persona> pers = persServ.buscarElemento(id);
        Path path = imgServ.getRootPath().resolve("imagen-perfil-"+id+".png");
        imgServ.borrarImagen(path);
        pers.get().setImagenPerfil("");
        GetPutPersona objCambios = modelMapper.map(pers.get(), GetPutPersona.class);
        persServ.editarElemento(objCambios);
    }
    
    @DeleteMapping("borrar-imagen/banner/{id}")
    public void borrarImagenBanner (@PathVariable Long id) {
        Optional<Persona> pers = persServ.buscarElemento(id);
        Path path = imgServ.getRootPath().resolve("imagen-banner-"+id+".png");
        imgServ.borrarImagen(path);
        pers.get().setBanner("");
        GetPutPersona objCambios = modelMapper.map(pers.get(), GetPutPersona.class);
        persServ.editarElemento(objCambios);
    }

    /*   
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
    }
    @GetMapping("/files")
    public ResponseEntity<List<Imagen>> getListFiles() {
        List<Imagen> fileInfos = storServ.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder.fromMethodName(ImagenController.class, "getFile", path.getFileName().toString()).build().toString();
            return new Imagen(filename, url);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }
    */
}

/*
public class Imagen  {
    
    private String name;
    private String url;
    
    public Imagen(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
*/

//https://www.bezkoder.com/spring-boot-file-upload/
