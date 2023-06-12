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

    @Override
    public Opinion createOpinion(Opinion opinion) {
        Usuario usuario = usuarioRepository.findById(opinion.getClient().getId()).get();
        Inmueble inmueble = inmuebleRepository.findById(opinion.getInmueble().getId()).get();
        Opinion newOpinion = new Opinion(usuario, inmueble, opinion.getCalificacion(), opinion.getObservaciones(), opinion.getLinkFoto());
        Opinion savedOpinion = opinionRepository.save(newOpinion);
        savedOpinion.getClient().setOpiniones(null);
        savedOpinion.getInmueble().setOpiniones(null);
        return savedOpinion;
    }

    @Override
    public List<Opinion> listOpinionByUser(Long id) {
        List<Opinion> opinionList = opinionRepository.findByClient_Id(id);
        for(Opinion o: opinionList){
            o.getClient().setOpiniones(null);
            o.getInmueble().setOpiniones(null);
        }
        return opinionList;
    }
}
