package com.example.discoverbackend.servicesimpl;

import com.example.discoverbackend.entities.Usuario;
import com.example.discoverbackend.repositories.UsuarioRepository;
import com.example.discoverbackend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario) {
        Usuario newUsuario = new Usuario(usuario.getFirstName(), usuario.getLastNameDad(), usuario.getLastNameMom(), usuario.getDni(), usuario.getTelephone(), usuario.getEmail(), usuario.getPassword(), usuario.getLinkPhotoDni(), usuario.getLinkPhotoProfile(), usuario.getDateBirth(), usuario.getDateAffiliation());
        Usuario saveUsuario = usuarioRepository.save(newUsuario);
        return saveUsuario;
    }
}
