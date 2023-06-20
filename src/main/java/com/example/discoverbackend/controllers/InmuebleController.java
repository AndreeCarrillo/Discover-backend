package com.example.discoverbackend.controllers;

import com.example.discoverbackend.entities.Inmueble;
import com.example.discoverbackend.entities.Usuario;
import com.example.discoverbackend.services.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.EmptyStackException;

import java.util.List;

@CrossOrigin(origins = "https://localhost:4200")
@RestController
@RequestMapping("/api")
public class InmuebleController {

    @Autowired
    InmuebleService inmuebleService;

    @GetMapping("/inmuebles")
    public ResponseEntity<List<Inmueble>> getAllInmuebles(){
        List<Inmueble> inmuebles = inmuebleService.listAll();
        return new ResponseEntity<List<Inmueble>>(inmuebles, HttpStatus.OK);
    }

    @GetMapping("/inmuebles/{id}")
    public ResponseEntity<Inmueble> getInmueblesById(@PathVariable("id") Long id) {
        Inmueble inmueble = inmuebleService.listById(id);
        return new ResponseEntity<Inmueble>(inmueble, HttpStatus.OK);
    }

    @PostMapping ("/new-inmueble")
    public ResponseEntity<Inmueble> createInmueble(@RequestBody Inmueble inmueble) {
        Inmueble savedInmueble = inmuebleService.save(inmueble);
        return new ResponseEntity<Inmueble>(savedInmueble, HttpStatus.CREATED);
    }

    @DeleteMapping("/inmuebles/{id}")
    public ResponseEntity<HttpStatus> deleteInmueble(@PathVariable("id") Long id) {
    inmuebleService.delete(id, true);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
