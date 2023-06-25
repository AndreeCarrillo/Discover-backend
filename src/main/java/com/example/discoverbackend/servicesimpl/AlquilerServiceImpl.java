package com.example.discoverbackend.servicesimpl;

import com.example.discoverbackend.dtos.AlquilerRequest;
import com.example.discoverbackend.entities.Alquiler;
import com.example.discoverbackend.entities.Inmueble;
import com.example.discoverbackend.entities.InmuebleFoto;
import com.example.discoverbackend.entities.Usuario;
import com.example.discoverbackend.repositories.AlquilerRepository;
import com.example.discoverbackend.repositories.InmuebleRepository;
import com.example.discoverbackend.repositories.UsuarioRepository;
import com.example.discoverbackend.services.AlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AlquilerServiceImpl implements AlquilerService {

    @Autowired
    AlquilerRepository alquilerRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    InmuebleRepository inmuebleRepository;

    public Alquiler createAlquiler(Alquiler alquiler) {
        Usuario usuario = usuarioRepository.findById(alquiler.getClient().getId()).get();
        Inmueble inmueble = inmuebleRepository.findById(alquiler.getInmueble().getId()).get();
        Alquiler newAlquiler = new Alquiler(usuario, inmueble,alquiler.getPrice(), alquiler.getTransactionDate(), true);
        Alquiler savedAlquiler = alquilerRepository.save(newAlquiler);
        savedAlquiler.getClient().setInmuebles(null);
        savedAlquiler.getClient().setOpiniones(null);
        savedAlquiler.getInmueble().getUbigeo().setInmuebleZonaList(null);
        savedAlquiler.getInmueble().getUsuario().setInmuebles(null);
        savedAlquiler.getInmueble().getUsuario().setOpiniones(null);
        for(InmuebleFoto f: savedAlquiler.getInmueble().getInmuebleFotoList()){
            f.setInmueble(null);
            f.getFoto().setInmuebleFotos(null);
        }
        return savedAlquiler;
    }

    @Override
    public List<Alquiler> listAlquilerByUser(Long id) {
        List<Alquiler> alquilerList = alquilerRepository.findByClient_Id(id);
        for(Alquiler a: alquilerList){
            a.getClient().setInmuebles(null);
            a.getClient().setOpiniones(null);
            a.getInmueble().getUbigeo().setInmuebleZonaList(null);
            a.getInmueble().getUsuario().setInmuebles(null);
            a.getInmueble().getUsuario().setOpiniones(null);
            a.getInmueble().setOpiniones(null);
            for(InmuebleFoto f: a.getInmueble().getInmuebleFotoList()){
                f.setInmueble(null);
                f.getFoto().setInmuebleFotos(null);
            }
        }
        return alquilerList;
    }

    @Override
    public Alquiler updateAlquiler(Long id) {
        Alquiler alquiler = alquilerRepository.findById(id).get();
        alquiler.setActivate(!alquiler.getActivate());
        alquiler.getClient().setInmuebles(null);
        alquiler.getClient().setOpiniones(null);
        alquiler.getInmueble().getUbigeo().setInmuebleZonaList(null);
        alquiler.getInmueble().getUsuario().setInmuebles(null);
        alquiler.getInmueble().getUsuario().setOpiniones(null);
        for(InmuebleFoto f: alquiler.getInmueble().getInmuebleFotoList()){
            f.setInmueble(null);
            f.getFoto().setInmuebleFotos(null);
        }
        return alquilerRepository.save(alquiler);
    }

    public List<AlquilerRequest> listAlquilerRequest() {
        List<Alquiler> alquilerList = alquilerRepository.findAll();
        List<AlquilerRequest> alquilerRequestList = new ArrayList<>();

        for(Alquiler a: alquilerList) {

            String location = a.getInmueble().getAddress();
            String fullNameOwner = a.getClient().getFirstName() + " " + a.getClient().getLastNameDad() + " " +a.getClient().getLastNameMom();
            Double price = a.getPrice();
            Date transactionDate = a.getTransactionDate();
            Boolean active = a.getActivate();
            Long property_id = a.getInmueble().getId();

            AlquilerRequest alquilerRequest = new AlquilerRequest(location, fullNameOwner, price, transactionDate, active, property_id);
            alquilerRequestList.add(alquilerRequest);

        }

        return alquilerRequestList;

    }
}
