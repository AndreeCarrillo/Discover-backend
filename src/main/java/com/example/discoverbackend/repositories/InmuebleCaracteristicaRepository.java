package com.example.discoverbackend.repositories;

import com.example.discoverbackend.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InmuebleCaracteristicaRepository extends JpaRepository<InmuebleCaracteristica,Long> {

    @Query(value = "SELECT*FROM InmuebleCaracteristica where inmueble_id=?1", nativeQuery = true)
    List<InmuebleCaracteristica> findByInmueble_Id(Long id);

}
