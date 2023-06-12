package com.example.discoverbackend.servicesimpl;

import com.example.discoverbackend.entities.Alquiler;
import com.example.discoverbackend.entities.Inmueble;
import com.example.discoverbackend.entities.Usuario;
import com.example.discoverbackend.repositories.AlquilerRepository;
import com.example.discoverbackend.repositories.InmuebleRepository;
import com.example.discoverbackend.repositories.UsuarioRepository;
import com.example.discoverbackend.services.AlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlquilerServiceImpl implements AlquilerService {

    @Autowired
    AlquilerRepository alquilerRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    InmuebleRepository inmuebleRepository;

    @Override
    public Alquiler createAlquiler(Alquiler alquiler) {
        Usuario usuario = usuarioRepository.findById(alquiler.getClient().getId()).get();
        Inmueble inmueble = inmuebleRepository.findById(alquiler.getInmueble().getId()).get();
        Alquiler newAlquiler = new Alquiler(usuario, inmueble,alquiler.getPrice(), alquiler.getTransactionDate(), true);
        Alquiler savedAlquiler = alquilerRepository.save(newAlquiler);
        //savedAlquiler.setClient(null);
        //savedAlquiler.setInmueble(null);
        savedAlquiler.getClient().setInmuebles(null);
        savedAlquiler.getInmueble().setUbigeo(null);
        savedAlquiler.getInmueble().getUsuario().setInmuebles(null);
        return savedAlquiler;
    }

    @Override
    public List<Alquiler> listAlquilerByUser(Long id) {
        List<Alquiler> alquilerList = alquilerRepository.findByClient_Id(id);
        for(Alquiler a: alquilerList){
            a.getClient().setInmuebles(null);
            a.getInmueble().setUbigeo(null);
            a.getInmueble().getUsuario().setInmuebles(null);
        }
        return alquilerList;
    }

    @Override
    public Alquiler updateAlquiler(Long id) {
        Alquiler alquiler = alquilerRepository.findById(id).get();
        alquiler.setActivate(false);
        alquiler.getClient().setInmuebles(null);
        alquiler.getInmueble().setUbigeo(null);
        alquiler.getInmueble().getUsuario().setInmuebles(null);
        return alquilerRepository.save(alquiler);
    }
}
