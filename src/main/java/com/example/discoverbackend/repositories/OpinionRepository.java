package com.example.discoverbackend.repositories;

import com.example.discoverbackend.entities.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpinionRepository extends JpaRepository<Opinion, Long> {
    List<Opinion> findByClient_Id (Long id);
}
