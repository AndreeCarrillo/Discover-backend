package com.example.discoverbackend.controllers;

import com.example.discoverbackend.entities.Alquiler;
import com.example.discoverbackend.entities.Opinion;
import com.example.discoverbackend.services.AlquilerService;
import com.example.discoverbackend.services.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "htpp://localhost:4200")
@RestController
@RequestMapping("/api")
public class OpinionController {

    @Autowired
    OpinionService opinionService;

    @PostMapping("/opinion")
    public ResponseEntity<Opinion> saveOpinion(@RequestBody Opinion opinion){
        Opinion saveOpinion = opinionService.createOpinion(opinion);
        return new ResponseEntity<Opinion>(saveOpinion, HttpStatus.CREATED);
    }

    @GetMapping("/opinion/{user_id}")
    public ResponseEntity<List<Opinion>> allOpinionByUserId (@PathVariable Long user_id){
        List<Opinion> opinionList = opinionService.listOpinionByUser(user_id);
        return new ResponseEntity<List<Opinion>>(opinionList, HttpStatus.OK);
    }

}