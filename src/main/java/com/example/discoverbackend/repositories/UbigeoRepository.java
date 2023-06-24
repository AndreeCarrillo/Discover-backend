package com.example.discoverbackend.repositories;

import com.example.discoverbackend.entities.Ubigeo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UbigeoRepository extends JpaRepository<Ubigeo, Long> {

    //JPQL DE QUERY DE SELECCIONAR ID UBIGEO CUANDO DEPARTAMENTO, PROVINCIA Y DISTRITO SEAN X, LLAMAR AL POST
}
