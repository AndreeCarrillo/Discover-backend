package com.example.discoverbackend.controllers;

import com.example.discoverbackend.entities.Usuario;
import com.example.discoverbackend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//aca falta para q se conecte con el localhost:4200, si alguien la pone se lo agradezco :D
@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
        Usuario savedUsuario = usuarioService.save(usuario);
        return new ResponseEntity<Usuario>(savedUsuario, HttpStatus.CREATED);
    }
}
