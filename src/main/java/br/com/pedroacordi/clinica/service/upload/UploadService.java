package br.com.pedroacordi.clinica.service.upload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Component
public class UploadService implements IUploadService{

    @Value("${clinic.folder}")
    private String PATH;

    @Value("${clinic.folder-front}")
    private String PATH_FRONT;

    @Override
    public String uploadFile(MultipartFile file) {
        try{
            String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String newFilename = UUID.randomUUID().toString() + extension;
            Path path = Paths.get(PATH + File.separator + newFilename );
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            return PATH_FRONT+newFilename;
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteFile(String path) {
        String filepath = PATH.substring(0, PATH.indexOf("/src/") +4 ) + path;
        File file = new File(filepath);
        if(file.exists()){
            if(!file.delete())
                return false;
            return true;
        }
        return true;
    }
}
