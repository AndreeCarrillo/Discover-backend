package com.example.discoverbackend.repositories;

import com.example.discoverbackend.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {

    /*
    * @Query("SELECT u FROM Usuario u WHERE u.linkPhotoProfile=? 1")
    List<Usuario> userWithProfilePicture();
    * */




}
