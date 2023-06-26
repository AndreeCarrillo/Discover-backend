package com.example.discoverbackend.repositories;

import com.example.discoverbackend.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InmuebleCaracteristicaRepository extends JpaRepository<InmuebleCaracteristica,Long> {
    List<InmuebleCaracteristica> findByInmueble_Id(Long id);

}
