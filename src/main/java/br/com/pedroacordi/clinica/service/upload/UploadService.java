package br.com.pedroacordi.clinica.service.upload;

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
    private static final String PATH = "E:\\JavaProjects\\Clinica\\images";

    @Override
    public String uploadFile(MultipartFile file) {
        try{

            String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String newFilename = UUID.randomUUID().toString() + extension;
            Path path = Paths.get(PATH + File.separator + newFilename );
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            return newFilename;
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
