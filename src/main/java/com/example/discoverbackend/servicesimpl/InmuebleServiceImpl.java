package com.example.discoverbackend.servicesimpl;

import com.example.discoverbackend.dtos.PrincipalInmueblesResponse;
import com.example.discoverbackend.entities.*;
import com.example.discoverbackend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.discoverbackend.services.InmuebleService;
import org.springframework.stereotype.Service;
import com.example.discoverbackend.dtos.InmuebleRequest;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class InmuebleServiceImpl implements InmuebleService {

    @Autowired
    InmuebleRepository inmuebleRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    UbigeoRepository ubigeoRepository;
    @Autowired
    CaracteristicaRepository caracteristicaRepository;
    @Autowired
    InmuebleCaracteristicaRepository inmuebleCaracteristicaRepository;

    public List<PrincipalInmueblesResponse> listAll(){
        List<PrincipalInmueblesResponse> propertiesResponse = new ArrayList<>();
        List<Inmueble> properties=inmuebleRepository.findAll();
        for(Inmueble i: properties){
            String linkPhotoUser = i.getUsuario().getLinkPhotoProfile();
            String fullName = i.getUsuario().getFirstName() + i.getUsuario().getLastNameDad() + i.getUsuario().getLastNameMom();
            String province = i.getUbigeo().getProvincia();
            String department = i.getUbigeo().getDepartamento();
            String district = i.getUbigeo().getDistrito();
            String linkPhotoProperty = i.getInmuebleFotoList().get(0).getFoto().getPhotoLink();
            Double price = i.getPrice();
            Integer squareMeter = i.getSquareMeter();
            Integer numBedrooms = i.getNumBedrooms();
            Integer numBathrooms = i.getNumBathrooms();
            String description = i.getDescription();
            propertiesResponse.add(new PrincipalInmueblesResponse(linkPhotoUser, fullName, province, department, district, linkPhotoProperty, price, squareMeter, numBedrooms, numBathrooms, description));
        }
        return propertiesResponse;
    }
    public Inmueble listById(Long id){
        Inmueble inmueble;
        inmueble=inmuebleRepository.findById(id).orElseThrow();
        inmueble.getUsuario().setInmuebles(null);
        inmueble.getUsuario().setOpiniones(null);
        inmueble.setOpiniones(null);
        inmueble.getUbigeo().setInmuebleZonaList(null);
        for(InmuebleFoto foto: inmueble.getInmuebleFotoList()){
            foto.setInmueble(null);
            foto.getFoto().setInmuebleFotos(null);
        }
        return inmueble;
    }

    @Transactional
    public Inmueble save(InmuebleRequest inmueble){
        Inmueble newInmueble = inmuebleRepository.save(new Inmueble(inmueble.getPropertyType(), inmueble.getSharedRoom(), inmueble.getAddress(), inmueble.getPrice(), inmueble.getNumBedrooms(), inmueble.getNumBathrooms(), inmueble.getNumGuests(), inmueble.getSquareMeter(), inmueble.getTimeAntiquity(), inmueble.getDescription(), inmueble.getUsuario(), inmueble.getUbigeo()));
        newInmueble.getUsuario().setInmuebles(null);
        newInmueble.getUsuario().setOpiniones(null);
        newInmueble.setOpiniones(null);
        newInmueble.getUbigeo().setInmuebleZonaList(null);
        for(InmuebleFoto foto: newInmueble.getInmuebleFotoList()){
            foto.setInmueble(null);
            foto.getFoto().setInmuebleFotos(null);
        }
        for (Long caracteristicaId : inmueble.getCaracteristicasIds()){
            InmuebleCaracteristica inmuebleCaracteristica = new InmuebleCaracteristica(newInmueble, caracteristicaRepository.findById(caracteristicaId).get());
            inmuebleCaracteristicaRepository.save(inmuebleCaracteristica);
        }
        return newInmueble;
    }
    @Transactional
    public void delete(Long id, boolean forced) {
        Inmueble inmueble = inmuebleRepository.findById(id).get();
        inmuebleRepository.delete(inmueble);
    }

}
