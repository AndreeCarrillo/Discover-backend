package com.example.discoverbackend.servicesimpl;

import com.example.discoverbackend.dtos.DTOContactoUsuario;
import com.example.discoverbackend.entities.Usuario;
import com.example.discoverbackend.repositories.UsuarioRepository;
import com.example.discoverbackend.services.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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


    public List<DTOContactoUsuario> listContactoUsuario(Long id) {
        List<Usuario> usuarioList = usuarioRepository.findAll();
        List<DTOContactoUsuario> dtoContactoUsuarioList = new ArrayList<>();
        String monthString = new String();
        String dayString = new String();
        for (Usuario u: usuarioList){
            if (u.getId() == id)
            {
                String fullname = u.getFirstName()+" "+u.getLastNameDad()+" "+u.getLastNameMom();

                Integer year = u.getDateAffiliation().getYear() + 1900;
                Integer month = u.getDateAffiliation().getMonth() + 1; //2022 - 3 - 6     2022-03-06
                Integer day = u.getDateAffiliation().getDate();

                if (month<10){
                    monthString = "0"+month;

                }else if (month>=10){
                    monthString = month.toString();
                }
                if (day<10){
                    dayString="0"+day;
                }else if (day>=10) {
                    dayString=day.toString();
                }

                String dateString = year + " - " + monthString + " - " + dayString;
                DTOContactoUsuario dtoContactoUsuario = new DTOContactoUsuario(fullname, u.getTelephone(), u.getEmail(), dateString);
                dtoContactoUsuarioList.add(dtoContactoUsuario);
                dayString="";
                monthString="";
            }

        }
        return dtoContactoUsuarioList;
    }
}
