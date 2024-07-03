package br.com.pedroacordi.clinica.controller;

import br.com.pedroacordi.clinica.dto.PathToFile;
import br.com.pedroacordi.clinica.model.MessageModel;
import br.com.pedroacordi.clinica.service.upload.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @DeleteMapping("/upload")
    public ResponseEntity<MessageModel> deleteFile(@RequestParam(name="path") String path){
        return service.deleteFile(path)
                ? ResponseEntity.status(200).body(new MessageModel("Arquivo excluído"))
                : ResponseEntity.badRequest().build();
    }
}
