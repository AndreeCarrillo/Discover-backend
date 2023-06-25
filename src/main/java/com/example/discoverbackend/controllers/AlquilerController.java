package com.example.discoverbackend.controllers;

import com.example.discoverbackend.dtos.AlquilerRequest;
import com.example.discoverbackend.dtos.AlquilerResponse;
import com.example.discoverbackend.entities.Alquiler;
import com.example.discoverbackend.services.AlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "htpp://localhost:4200")
@RestController
@RequestMapping("/api")
public class AlquilerController {
    @Autowired
    AlquilerService alquilerService;

    @PostMapping("/alquiler")
    public ResponseEntity<Alquiler> saveAlquiler(@RequestBody AlquilerRequest alquiler) {
        Alquiler savealquiler = alquilerService.createAlquiler(alquiler);
        return new ResponseEntity<Alquiler>(savealquiler, HttpStatus.CREATED);
    }

    @GetMapping("/alquiler/{user_id}")
    public ResponseEntity<List<AlquilerResponse>> allAlquilerByUserId(@PathVariable Long user_id) {
        List<AlquilerResponse> alquilerList = alquilerService.listAlquilerByUser(user_id);
        return new ResponseEntity<List<AlquilerResponse>>(alquilerList, HttpStatus.OK);
    }

    @PutMapping("/alquiler/{id}")
    public ResponseEntity<Alquiler> setActivateAlquiler(@PathVariable Long id) {
        Alquiler alquiler = alquilerService.updateAlquiler(id);
        return new ResponseEntity<Alquiler>(alquiler, HttpStatus.OK);
    }

}
