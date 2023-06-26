package com.example.discoverbackend.controllers;

import com.example.discoverbackend.dtos.DTOContactoUsuario;
import com.example.discoverbackend.entities.Usuario;
import com.example.discoverbackend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "https://localhost:4200")
@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/new-usuario")
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
        Usuario savedUsuario = usuarioService.save(usuario);
        return new ResponseEntity<Usuario>(savedUsuario, HttpStatus.CREATED);
    }

    @GetMapping("/contact/{id}")
    public ResponseEntity<DTOContactoUsuario> listContactUsuario(@PathVariable("id") Long id){
        DTOContactoUsuario dtoContactoUsuarios = usuarioService.listContactoUsuario(id);
        return new ResponseEntity<DTOContactoUsuario>(dtoContactoUsuarios, HttpStatus.OK);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<HttpStatus> deleteUsuario(@PathVariable("id") Long id) {
        usuarioService.delete(id, true);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
