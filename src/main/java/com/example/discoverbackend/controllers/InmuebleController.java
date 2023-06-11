package com.example.discoverbackend.controllers;

import com.example.discoverbackend.entities.Inmueble;
import com.example.discoverbackend.services.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
=======
import java.util.EmptyStackException;
>>>>>>> 0bcc5c7027ed3d59af720dc54c2f8aefca7d35af
import java.util.List;

@CrossOrigin(origins = "htpp://localhost:4200")
@RestController
@RequestMapping("/api")
public class InmuebleController {

    @Autowired
    InmuebleService inmuebleService;

    @GetMapping("/inmuebles")
    public ResponseEntity<List<Inmueble>> getAllInmuebles() {
        List<Inmueble> inmuebles = inmuebleService.listAll();
        return new ResponseEntity<List<Inmueble>>(inmuebles, HttpStatus.OK);
    }

    @GetMapping("/inmuebles/{id}")
    public ResponseEntity<Inmueble> getInmueblesById(@PathVariable("id") Long id) {
        Inmueble inmueble = inmuebleService.listById(id);
        return new ResponseEntity<Inmueble>(inmueble, HttpStatus.OK);
    }

<<<<<<< HEAD
    @PostMapping("/inmuebles")
=======
    @PostMapping ("/inmuebles")
>>>>>>> 0bcc5c7027ed3d59af720dc54c2f8aefca7d35af
    public ResponseEntity<Inmueble> createInmueble(@RequestBody Inmueble inmueble) {
        Inmueble newInmueble = inmuebleService.save(inmueble);
        return new ResponseEntity<Inmueble>(newInmueble, HttpStatus.CREATED);
    }

<<<<<<< HEAD
    // @DeleteMapping("/inmuebles/{id}")
    //public ResponseEntity<HttpStatus> deleteInmueble(@PathVariable("id") Long id) {
    //inmuebleService.delete(id, true);
    //return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //}


=======
   // @DeleteMapping("/inmuebles/{id}")
    //public ResponseEntity<HttpStatus> deleteInmueble(@PathVariable("id") Long id) {
        //inmuebleService.delete(id, true);
        //return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //}

>>>>>>> 0bcc5c7027ed3d59af720dc54c2f8aefca7d35af
}
