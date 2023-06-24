package com.example.discoverbackend.servicesimpl;

import com.example.discoverbackend.dtos.DTOContactoUsuario;
import com.example.discoverbackend.entities.Usuario;
import com.example.discoverbackend.repositories.UsuarioRepository;
import com.example.discoverbackend.services.UsuarioService;
import javax.transaction.Transactional;
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
            u.setOpiniones(null);
        }
        return usuarios;
    }

    public Usuario listById(Long id) {
        Usuario usuario;
        usuario=usuarioRepository.findById(id).orElseThrow();
        usuario.setInmuebles(null);
        usuario.setOpiniones(null);
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


    public DTOContactoUsuario listContactoUsuario(Long id) {
        Usuario u = usuarioRepository.findById(id).get();
        String monthString = new String();
        String dayString = new String();
        String monthString1 = new String();
        String dayString1 = new String();

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

                Integer year1 = u.getDateBirth().getYear()+1900;
                Integer month1= u.getDateBirth().getMonth() + 1;
                Integer day1= u.getDateBirth().getDate();
                if (month1<10){
                    monthString1 = "0"+month;

                }else if (month1>=10){
                    monthString1 = month.toString();
                }
                if (day1<10){
                    dayString1="0"+day1;
                }else if (day1>=10) {
                    dayString1=day1.toString();
                }

                String dateString = year + " - " + monthString + " - " + dayString;
                String dateStringBirth = year1+" - "+monthString1+" - "+dayString1;
                DTOContactoUsuario dtoContactoUsuario = new DTOContactoUsuario(fullname, u.getTelephone(), u.getEmail(), dateString, dateStringBirth);

        return dtoContactoUsuario;
    }
}
