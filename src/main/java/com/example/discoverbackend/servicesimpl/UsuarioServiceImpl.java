package com.example.discoverbackend.servicesimpl;

import com.example.discoverbackend.entities.Usuario;
import com.example.discoverbackend.repositories.UsuarioRepository;
import com.example.discoverbackend.services.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> listAll() {
        List<Usuario> usuarios;
        usuarios = usuarioRepository.findAll();
        for (Usuario u: usuarios){
            u.setInmuebles(null);
        }
        return usuarios;
    }

    public Usuario listById(Long id) {
        Usuario usuario;
        usuario=usuarioRepository.findById(id).orElseThrow();
        usuario.setInmuebles(null);
        return usuario;
    }

    public Usuario save(Usuario usuario) {
        Usuario newUsuario = new Usuario(usuario.getFirstName(), usuario.getLastNameDad(), usuario.getLastNameMom(), usuario.getDni(), usuario.getTelephone(), usuario.getEmail(), usuario.getPassword(), usuario.getLinkPhotoDni(), usuario.getLinkPhotoProfile(), usuario.getDateBirth(), usuario.getDateAffiliation(), usuario.getInmuebles());
        Usuario savedUsuario = usuarioRepository.save(newUsuario);
        return savedUsuario;
    }

    @Transactional
    public void delete(Long id, boolean forced) {
        Usuario usuario = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuario);
    }
}
