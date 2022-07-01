package com.argentinaPrograma.PortFolio.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagenService implements ImagenServiceInterface {
    
    private final Path rootPath = Paths.get("uploads");
    
    @Override
    public Path getRootPath (){
        return this.rootPath;
    }
          
    @Override
    public void subirImagen(MultipartFile file, Long id, String tipo) {
        Path imgPath = null;
        switch (tipo){
            case "imagenPerfil": 
                imgPath =  this.rootPath.resolve("imagen-perfil-" + id + ".png");
                break; 
            case "banner": 
                imgPath =  this.rootPath.resolve("imagen-banner-" + id + ".png");
                break;
            case "imagenFondo": 
                imgPath =  this.rootPath.resolve("imagen-fondo-" + id + ".png");
                break;
            case "experiencia":
                imgPath =  this.rootPath.resolve("experiencia/imagen-" + id + ".png");
                break; 
            case "educacion":
                imgPath =  this.rootPath.resolve("educacion/imagen-" + id + ".png");
                break;
            case "proyecto":
                imgPath =  this.rootPath.resolve("proyecto/imagen-" + id + ".png");
                break; 
            default:
        }
        try {
            Files.deleteIfExists(imgPath);
            Files.copy(file.getInputStream(), imgPath);
        } catch (IOException e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }  
    
    @Override
    public Resource verImagen(String filename) {
        try {
            Path file = rootPath.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void borrarImagen(Path path) {
        try {
            Files.deleteIfExists(path);
        } catch (IOException ex) {
            Logger.getLogger(ImagenService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    /*
    
    @Override
    public Resource[] verImagenes(String path) {
        try {
            File folder = rootPath.resolve(path).toFile();
            File[] files = folder.listFiles();        
            Resource[] images = null;
            for (int i=0; i<files.length; i++){
                Resource image = new UrlResource(files[i].toPath().toUri());
                if (image.exists() || image.isReadable()) {
                    images[i] = image;
                }
            }
            return images;
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override 
    public void init() {
        try {
            Files.createDirectory(rootPath);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }
    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootPath.toFile());
    }
    @Override
    public Stream<Path> loadAll() {
        try {
        return Files.walk(this.rootPath, 1).filter(path -> !path.equals(this.rootPath)).map(this.rootPath::relativize);
        } catch (IOException e) {
        throw new RuntimeException("Could not load the files!");
        }
    }
    */
}