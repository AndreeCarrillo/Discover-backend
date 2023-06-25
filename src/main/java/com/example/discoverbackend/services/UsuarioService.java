package com.example.discoverbackend.services;

import com.example.discoverbackend.dtos.DTOContactoUsuario;
import com.example.discoverbackend.dtos.RegisterUserRequest;
import com.example.discoverbackend.entities.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioService {

    public Usuario save(RegisterUserRequest usuario);
    public Usuario listById(Long id);
    public void delete(Long id, boolean forced);
    public DTOContactoUsuario listContactoUsuario(Long id);
}
