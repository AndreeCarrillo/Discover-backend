package com.example.discoverbackend.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.discoverbackend.entities.Inmueble;
import com.example.discoverbackend.entities.Usuario;
import com.example.discoverbackend.entities.Ubigeo;
import com.example.discoverbackend.repositories.InmuebleRepository;
import com.example.discoverbackend.services.InmuebleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.discoverbackend.repositories.UbigeoRepository;
import com.example.discoverbackend.repositories.UsuarioRepository;
import com.example.discoverbackend.services.InmuebleService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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
        return inmuebles;
    }
    public Inmueble listById(Long id){
        Inmueble inmueble;
        inmueble=inmuebleRepository.findById(id).get();
        return inmueble;
    }

    @Transactional
    public Inmueble save(Inmueble inmueble){
        Inmueble newInmueble = inmuebleRepository.save(new Inmueble( inmueble.getPropertyType(), inmueble.getSharedRoom(), inmueble.getAddress(), inmueble.getPrice(), inmueble.getNumBedrooms(), inmueble.getNumBathrooms(), inmueble.getNumGuests(), inmueble.getSquareMeter(), inmueble.getTimeAntiquity(), inmueble.getPhotoLink(), inmueble.getDescription(), inmueble.getUsuario(), inmueble.getUbigeo()));
        return newInmueble;
    }

}
