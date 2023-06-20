package com.example.discoverbackend.servicesimpl;

import com.example.discoverbackend.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.discoverbackend.repositories.InmuebleRepository;
import com.example.discoverbackend.services.InmuebleService;
import com.example.discoverbackend.repositories.UbigeoRepository;
import com.example.discoverbackend.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InmuebleServiceImpl implements InmuebleService {

    @Autowired
    InmuebleRepository inmuebleRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    UbigeoRepository ubigeoRepository;

    public List<Inmueble> listAll(){
        List<Inmueble> inmuebles;
        inmuebles=inmuebleRepository.findAll();
        for (Inmueble i: inmuebles){
            i.getUsuario().setInmuebles(null);
            i.getUsuario().setOpiniones(null);
            i.setOpiniones(null);
            i.getUbigeo().setInmuebleZonaList(null);
            for(InmuebleFoto foto: i.getInmuebleFotoList()){
                foto.setInmueble(null);
                foto.getFoto().setInmuebleFotos(null);
            }
            //for(Opinion o: i.getOpiniones()){
               // o.setInmueble(null);
            // o.getClient().setOpiniones(null);
            // o.getClient().setInmuebles(null);
            //}
        }
        return inmuebles;
    }
    public Inmueble listById(Long id){
        Inmueble inmueble;
        inmueble=inmuebleRepository.findById(id).orElseThrow();
        inmueble.setUsuario(null);
        return inmueble;
    }

    @Transactional
    public Inmueble save(Inmueble inmueble){
        Inmueble newInmueble = inmuebleRepository.save(new Inmueble(inmueble.getPropertyType(), inmueble.getSharedRoom(), inmueble.getAddress(), inmueble.getPrice(), inmueble.getNumBedrooms(), inmueble.getNumBathrooms(), inmueble.getNumGuests(), inmueble.getSquareMeter(), inmueble.getTimeAntiquity(), inmueble.getDescription(), inmueble.getUsuario(), inmueble.getUbigeo()));
        return newInmueble;
    }
    @Transactional
    public void delete(Long id, boolean forced) {
        Inmueble inmueble = inmuebleRepository.findById(id).get();
        inmuebleRepository.delete(inmueble);
    }

}
