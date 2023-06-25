package com.example.discoverbackend.repositories;

import com.example.discoverbackend.entities.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleUserRepository extends JpaRepository<RoleUser, Long> {
}
