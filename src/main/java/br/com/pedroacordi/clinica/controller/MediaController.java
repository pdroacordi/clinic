package br.com.pedroacordi.clinica.controller;

import br.com.pedroacordi.clinica.model.Media;
import br.com.pedroacordi.clinica.model.MessageModel;
import br.com.pedroacordi.clinica.service.media.IMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class MediaController {

    @Autowired
    private IMediaService service;

    @GetMapping("/media/{id}")
    public ResponseEntity<Media> getById(@PathVariable Integer id){
        Media res = service.getById(id);
        if(res == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(res);
    }

    @PostMapping("/media")
    public ResponseEntity<Media> create(@RequestBody Media media){
        Media res = service.create(media);
        if(res == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.status(201).body(res);
    }

    @PutMapping("/media/{id}")
    public ResponseEntity<Media> update(@RequestBody Media media, @PathVariable Integer id){
        if(media.getId() == null)
            media.setId(id);

        Media res = service.update(media);
        if(res == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/media/{id}")
    public ResponseEntity<MessageModel> delete(@PathVariable Integer id){
        return service.delete( id )
                ? ResponseEntity.ok(new MessageModel("Mídia excluída com sucesso"))
                : ResponseEntity.notFound().build();
    }

}
