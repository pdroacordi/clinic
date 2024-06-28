package br.com.pedroacordi.clinica.controller;

import br.com.pedroacordi.clinica.model.User;
import br.com.pedroacordi.clinica.security.Token;
import br.com.pedroacordi.clinica.service.auth.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private IAuthService service;

    @PostMapping("/user")
    public ResponseEntity<User> create(@RequestBody User user){
        User res = service.create(user);
        return res != null
                ? ResponseEntity.status(201).body(res)
                : ResponseEntity.badRequest().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody User user){
        Token token = service.login(user);
        return token != null
                ? ResponseEntity.ok(token)
                : ResponseEntity.status(403).build();
    }
}
