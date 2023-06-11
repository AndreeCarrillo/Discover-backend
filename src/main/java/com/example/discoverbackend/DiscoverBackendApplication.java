package com.example.discoverbackend;

import com.example.discoverbackend.entities.Caracteristica;
import com.example.discoverbackend.entities.TipoCaracteristica;
import com.example.discoverbackend.repositories.CaracteristicaRepository;
import com.example.discoverbackend.repositories.TipoCaracteristicaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DiscoverBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoverBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner mappingDemo(
        CaracteristicaRepository caracteristicaRepository,
        TipoCaracteristicaRepository tipoCaracteristicaRepository
    ){
        return args -> {
            tipoCaracteristicaRepository.save(new TipoCaracteristica("Servicios"));
            tipoCaracteristicaRepository.save(new TipoCaracteristica("Comodidades"));
            tipoCaracteristicaRepository.save(new TipoCaracteristica("Elementos de seguridad"));
            tipoCaracteristicaRepository.save(new TipoCaracteristica("Caracteristicas del inmueble"));
            TipoCaracteristica tipo1 = tipoCaracteristicaRepository.findById(Long.valueOf(1)).get();
            TipoCaracteristica tipo2 = tipoCaracteristicaRepository.findById(Long.valueOf(2)).get();
            TipoCaracteristica tipo3 = tipoCaracteristicaRepository.findById(Long.valueOf(3)).get();
            TipoCaracteristica tipo4 = tipoCaracteristicaRepository.findById(Long.valueOf(4)).get();
            caracteristicaRepository.save(new Caracteristica("Wi-fi", tipo1));
            caracteristicaRepository.save(new Caracteristica("Cocina", tipo1));
            caracteristicaRepository.save(new Caracteristica("Lavadora", tipo1));
            caracteristicaRepository.save(new Caracteristica("Zona de trabajo", tipo1));
            caracteristicaRepository.save(new Caracteristica("Estacionamiento", tipo1));
            caracteristicaRepository.save(new Caracteristica("Aire acondicionado", tipo1));
            caracteristicaRepository.save(new Caracteristica("TV", tipo1));
            caracteristicaRepository.save(new Caracteristica("Estacionamiento de pago en las instalaciones", tipo1));
            caracteristicaRepository.save(new Caracteristica("Piscina", tipo2));
            caracteristicaRepository.save(new Caracteristica("Terraza", tipo2));
            caracteristicaRepository.save(new Caracteristica("Parrilla", tipo2));
            caracteristicaRepository.save(new Caracteristica("Zona de comida al aire libre", tipo2));
            caracteristicaRepository.save(new Caracteristica("Jacuzzi", tipo2));
            caracteristicaRepository.save(new Caracteristica("Lugar para hacer fogata", tipo2));
            caracteristicaRepository.save(new Caracteristica("Mesa de billar", tipo2));
            caracteristicaRepository.save(new Caracteristica("Chimenea interior", tipo2));
            caracteristicaRepository.save(new Caracteristica("Piano", tipo2));
            caracteristicaRepository.save(new Caracteristica("Equipo para hacer trabajo", tipo2));
            caracteristicaRepository.save(new Caracteristica("Acceso al lago", tipo2));
            caracteristicaRepository.save(new Caracteristica("Acceso a la playa", tipo2));
            caracteristicaRepository.save(new Caracteristica("Ducha exterior", tipo2));
            caracteristicaRepository.save(new Caracteristica("Detector de humo", tipo3));
            caracteristicaRepository.save(new Caracteristica("Botiquin de primeros auxilios", tipo3));
            caracteristicaRepository.save(new Caracteristica("Extintor de incendios", tipo3));
            caracteristicaRepository.save(new Caracteristica("Tranquilo", tipo4));
            caracteristicaRepository.save(new Caracteristica("Ideal para familias", tipo4));
            caracteristicaRepository.save(new Caracteristica("Excepcional", tipo4));
            caracteristicaRepository.save(new Caracteristica("Central", tipo4));
            caracteristicaRepository.save(new Caracteristica("Espacioso", tipo4));
            caracteristicaRepository.save(new Caracteristica("Elegante", tipo4));
        };
    }
}
