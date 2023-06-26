package com.example.discoverbackend.repositories;

import com.example.discoverbackend.entities.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InmuebleRepository extends JpaRepository<Inmueble, Long> {
    //JPQL

}
