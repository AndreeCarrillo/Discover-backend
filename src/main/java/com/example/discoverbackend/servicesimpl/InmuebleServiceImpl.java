package com.example.discoverbackend.servicesimpl;

<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 0bcc5c7027ed3d59af720dc54c2f8aefca7d35af
import com.example.discoverbackend.entities.Inmueble;
import com.example.discoverbackend.entities.Usuario;
import com.example.discoverbackend.entities.Ubigeo;
import com.example.discoverbackend.repositories.InmuebleRepository;
<<<<<<< HEAD
import com.example.discoverbackend.services.InmuebleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
=======
import com.example.discoverbackend.repositories.UbigeoRepository;
import com.example.discoverbackend.repositories.UsuarioRepository;
import com.example.discoverbackend.services.InmuebleService;
import jakarta.transaction.Transactional;
>>>>>>> 0bcc5c7027ed3d59af720dc54c2f8aefca7d35af
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
        Inmueble newInmueble = inmuebleRepository.save(new Inmueble(inmueble.getAddress(), inmueble.getPrice(), inmueble.getNumBedrooms(), inmueble.getNumBathrooms(), inmueble.getNumGuests(), inmueble.getSquareMeter(), inmueble.getTimeAntiquity(), inmueble.getPhotoLink(), inmueble.getDescription(), inmueble.getUsuario(), inmueble.getUbigeo()));
        return newInmueble;
    }

<<<<<<< HEAD
=======




>>>>>>> 0bcc5c7027ed3d59af720dc54c2f8aefca7d35af
}
