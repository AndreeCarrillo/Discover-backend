package com.example.discoverbackend.repositories;

import com.example.discoverbackend.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
