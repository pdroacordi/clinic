package br.com.pedroacordi.clinica.controller;

import br.com.pedroacordi.clinica.dto.PathToFile;
import br.com.pedroacordi.clinica.service.upload.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
public class UploadController {

    @Autowired
    private IUploadService service;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam(name="file") MultipartFile file){
        String filename = service.uploadFile(file);
        return filename != null
                ? ResponseEntity.status(201).body(new PathToFile(filename))
                : ResponseEntity.badRequest().build();
    }
}
