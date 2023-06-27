package com.example.discoverbackend.repositories;

import com.example.discoverbackend.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {


@Query(value="Select*from usuarios where email=?1", nativeQuery = true)
    Usuario findByEmail(String email);

}
