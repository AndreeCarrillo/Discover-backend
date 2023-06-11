package com.example.discoverbackend.services;

import com.example.discoverbackend.entities.Usuario;

import java.util.List;

public interface UsuarioService {

    public Usuario save(Usuario usuario);

    public List<Usuario> listAll();
    public Usuario listById(Long id);

    public void delete(Long id, boolean forced);

}
