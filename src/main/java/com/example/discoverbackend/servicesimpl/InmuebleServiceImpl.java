package com.example.discoverbackend.servicesimpl;

import com.example.discoverbackend.dtos.*;
import com.example.discoverbackend.entities.*;
import com.example.discoverbackend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.discoverbackend.services.InmuebleService;
import org.springframework.stereotype.Service;

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
    @Autowired
    InmuebleFotoRepository inmuebleFotoRepository;
    @Autowired
    UsuarioServiceImpl usuarioService;

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
    public List<DTOIconCaracteristica> getInmuebleCharacteristics(Inmueble inmueble) {
        List<InmuebleCaracteristica> inmuebleCaracteristicas = inmueble.getCaracteristicaList();
        List<DTOIconCaracteristica> dtoIconCaracteristicas = new ArrayList<>();
        for (InmuebleCaracteristica inmuebleCaracteristica : inmuebleCaracteristicas) {
            Caracteristica caracteristica = inmuebleCaracteristica.getCaracteristica();
            dtoIconCaracteristicas.add(new DTOIconCaracteristica(caracteristica.getName(), caracteristica.getIcon()));
        }
        return dtoIconCaracteristicas;
    }
    public List<DTOOpinion> getInmuebleOpinions(Inmueble inmueble) {
        List<Opinion> inmuebleOpiniones = inmueble.getOpiniones();
        List<DTOOpinion> dtoOpinions = new ArrayList<>();
        for (Opinion opinion : inmuebleOpiniones) {
            dtoOpinions.add(new DTOOpinion(opinion.getObservaciones(), opinion.getCalificacion()));
        }
        return dtoOpinions;
    }
    public ShowInmuebleResponse listDataInmueble(Long id){
        Inmueble i = inmuebleRepository.findById(id).get();
        List<InmuebleFoto> inmuebleFotos = inmuebleFotoRepository.findByInmueble_Id(id);
        List<String> photoUrls = new ArrayList<>();
        for (InmuebleFoto inmuebleFoto : inmuebleFotos) {
            photoUrls.add(inmuebleFoto.getFoto().getPhotoLink());
        }
        List<DTOIconCaracteristica> listCaracteristaInmuebleIcons = getInmuebleCharacteristics(i);
        DTOContactoUsuario owner =usuarioService.listContactoUsuario(i.getUsuario().getId());
        List<DTOOpinion> listOpinions = getInmuebleOpinions(i);

        ShowInmuebleResponse showInmuebleResponse = new ShowInmuebleResponse(i.getAddress(), i.getTimeAntiquity(),photoUrls, i.getPrice(),i.getNumGuests(),listCaracteristaInmuebleIcons,owner,i.getUsuario().getLinkPhotoProfile(),i.getNumBedrooms(),i.getNumBathrooms(), i.getSquareMeter(),i.getDescription(),listOpinions);
        return showInmuebleResponse;

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
