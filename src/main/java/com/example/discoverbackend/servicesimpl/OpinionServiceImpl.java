package com.example.discoverbackend.servicesimpl;

import com.example.discoverbackend.entities.Inmueble;
import com.example.discoverbackend.entities.Opinion;
import com.example.discoverbackend.entities.Usuario;
import com.example.discoverbackend.repositories.InmuebleRepository;
import com.example.discoverbackend.repositories.OpinionRepository;
import com.example.discoverbackend.repositories.UsuarioRepository;
import com.example.discoverbackend.services.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpinionServiceImpl implements OpinionService {

    @Autowired
    OpinionRepository opinionRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    InmuebleRepository inmuebleRepository;

    public Opinion createOpinion(Opinion opinion) {
        Usuario usuario = usuarioRepository.findById(opinion.getUsuario().getId()).get();
        Inmueble inmueble = inmuebleRepository.findById(opinion.getInmueble().getId()).get();
        Opinion newOpinion = new Opinion(usuario, inmueble, opinion.getCalificacion(), opinion.getObservaciones(), opinion.getLinkFoto());
        Opinion savedOpinion = opinionRepository.save(newOpinion);
        savedOpinion.getUsuario().setOpiniones(null);
        savedOpinion.getInmueble().setOpiniones(null);
        return savedOpinion;
    }

    public List<Opinion> listOpinionByUser(Long id) {
        List<Opinion> opinionList = opinionRepository.findByUsuario_Id(id);
        for(Opinion o: opinionList){
            o.setUsuario(null);
            o.setInmueble(null);
        }
        return opinionList;
    }

    public List<Opinion> listAll(){
        List<Opinion> opinions;
        opinions = opinionRepository.findAll();
        for (Opinion o: opinions){
            o.setUsuario(null);
            o.setInmueble(null);
        }
        return opinions;
    }
}
