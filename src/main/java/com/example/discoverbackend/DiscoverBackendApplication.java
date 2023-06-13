package com.example.discoverbackend;

import com.example.discoverbackend.entities.*;
import com.example.discoverbackend.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class DiscoverBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoverBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner mappingDemo(
        CaracteristicaRepository caracteristicaRepository,
        TipoCaracteristicaRepository tipoCaracteristicaRepository,
        InmuebleRepository inmuebleRepository,
        UsuarioRepository usuarioRepository,
        UbigeoRepository ubigeoRepository
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

            System.out.println("--------------");


            usuarioRepository.save(new Usuario("Vanessa", "Castillo", "Gomes", "43451826", "901023352","vanessa.castillo@gmail.com","vanessa_2kamx","https://i.postimg.cc/6QN9f9wF/documento-identidad-peru-vanessa.jpg","https://i.postimg.cc/15qXG7wn/Screenshot-2023-05-01-220937.jpg", new Date(86, 1, 18), new Date(123, 3, 1), null));
            usuarioRepository.save(new Usuario("Carlos", "Rodríguez","Salas", "23456789", "901012352", "carlos.rodriguez@outlook.com", "Carlos1234", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg","https://i.postimg.cc/nL8PsrZ9/hombre-foto.jpg", new Date(1985,05,15), new Date(2023,04,02), null ));
            usuarioRepository.save(new Usuario("Fernanda","Gómez", "Vargas","34567890","345678921","fernanda.gomez@yahoo.com","Fernanda1234","https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg","https://i.postimg.cc/BZc4JWTC/retrato-de-joven-feliz-positivo-sonriendo-c-mara-166576783.jpg", new Date(1992,10,30), new Date(2023,04,05),null));
            usuarioRepository.save(new Usuario("Miguel",  "Sánchez", "Ortiz", "12345696", "923457822", "miguel.sanchez@outlook.com", "Miguel1234", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/qqgLDH4d/inline-image-preview.jpg", new Date(1980,12,20), new Date(2023,04,29), null));
            usuarioRepository.save(new Usuario("María",  "Fernández", "Castañeda", "12345697", "912345792", "maria.fernandez@gmail.com", "Maria1234", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/1zZvmdcp/photo-1659332589233-3637f89be936.jpg", new Date(95,10,10), new Date(2023,04,30), null));
            usuarioRepository.save(new Usuario("Juan",  "Perez", "Paz", "12345678", "987654321", "juan.perez@gmail.com", "Juan1234", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/zXb7nNxC/istockphoto-1212501093-640x640.jpg", new Date(95,10,15), new Date(2022,1,1), null));
            usuarioRepository.save(new Usuario("María",  "López", "Vázquez", "87654321", "765432109", "maria.lopez@example.com", "Maria5678", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/zDcZzJLK/women-i-am-young-girls-beautiful.jpg", new Date(1990,2,12), new Date(2022,03,15), null));
            usuarioRepository.save(new Usuario("Pedro",  "Ramírez", "Gutiérrez", "98765432", "876543210", "pedro.ramirez@example.com", "Pedro9012", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/6Q0f9pQX/happy-smile-face.jpg", new Date(1985,05,20), new Date(2022,05,10), null));
            usuarioRepository.save(new Usuario("Luis",  "Gonzales", "Vargas", "34567891", "987654321", "luis.gonzales@example.com", "Luis4567", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/Rh37Q1LS/pexels-photo-6421292.jpg", new Date(88,07,20), new Date(2022,06,05), null));
            usuarioRepository.save(new Usuario("Mónica",  "Díaz", "López", "45678912", "987654321", "monica.diaz@example.com", "Monica8910", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/q7k2ZHxZ/concepto-de-bienestar-y-personas-cierre-una-atractiva-rubia-sonriendo-con-dientes-blancos-mirando-la.jpg", new Date(93,02,18), new Date(2022,9,01), null));
            usuarioRepository.save(new Usuario("Jorge",  "Flores", "Castro", "56789123", "947654321", "jorge.flores@example.com", "Jorge2345", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://example.com/foto_perfil.jpg", new Date(98,11,28), new Date(2022,10,15), null));
            usuarioRepository.save(new Usuario("Carmen",  "Guzmán", "Ramírez", "67891234", "987624321", "carmen.guzman@example.com", "Carmen3456", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/44K21pdH/personas-reales-feliz-chica-natural-sonriendo-y-mirando-t-mido-la-c-mara-ruboriz-ndose-de-halagos-pi.jpg", new Date(1980,06,05), new Date(2022,12,01), null));
            usuarioRepository.save(new Usuario("Antonio",  "Vega", "López", "78912345", "907654817", "antonio.vega@example.com", "Antonio7890", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/j5n6yQXs/joven-dispara-con-su-c-mara-retrato-de-un-asi-tico-gracioso-tomando-fotos-disparando-fot-grafo-casua.jpg", new Date(91,03,14), new Date(2023,01,15), null));
            usuarioRepository.save(new Usuario("Sofía",  "Mendoza", "Gómez", "89123456", "917653021", "sofia.mendoza@example.com", "Sofia5678", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/Y9vRbwpB/portrait-people-cute-girl-smile.jpg", new Date(97,9,20), new Date(2023,03,01), null));
            usuarioRepository.save(new Usuario("Miguel",  "Castillo", "Hernández", "91234567", "985657311", "miguel.castillo@example.com", "Miguel1234", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/Gm3kX1Qg/man-person-portrait-sitting-smile-smiling-wear-looking-at-camera-one-person-real-people.jpg", new Date(92,12,10), new Date(2023,04,15), null));
            usuarioRepository.save(new Usuario("Laura",  "Martínez", "Vargas", "34567891", "957354001", "laura.martinez@example.com", "Laura5678", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/9McV7JV9/female-indian-young-girl-woman-people.jpg", new Date(87,3,5), new Date(2023,06,01), null));
            usuarioRepository.save(new Usuario("Lorena",  "Hernández", "Sánchez", "45678912", "922654321", "lorena.hernandez@example.com", "Lorena9012", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/zXxLXHCp/istockphoto-1443543154-170667a.jpg", new Date(95,8,2), new Date(2023,8,15), null));
            usuarioRepository.save(new Usuario("Javier",  "González", "Morales", "56789123", "917654451", "javier.gonzalez@example.com", "Javier3456", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/0yJ8Rzcz/pexels-photo-5215015.jpg", new Date(1984,11,12), new Date(2023,10,12), null));
            usuarioRepository.save(new Usuario("Marisol",  "Sánchez", "López", "67891234", "981234321", "marisol.sanchez@example.com", "Marisol1234", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/J01nRRt9/sonriente-mujer-bonita-joven-mirando-camara-tocar-cara-1262-15253.jpg", new Date(90,06,18), new Date(2023,11,01), null));
            usuarioRepository.save(new Usuario("Gustavo",  "García", "Pérez", "78912345", "987111321", "gustavo.garcia@example.com", "Gustavo5678", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/SRNywVv4/person-smiling.jpg", new Date(1982,9,28), new Date(2023,12,15), null));





            Usuario usuario1 = usuarioRepository.findById(Long.valueOf(1)).get();
            Usuario usuario2 = usuarioRepository.findById(Long.valueOf(2)).get();
            Usuario usuario3 = usuarioRepository.findById(Long.valueOf(3)).get();
            Usuario usuario4 = usuarioRepository.findById(Long.valueOf(4)).get();

            System.out.println("--------------");

            ubigeoRepository.save(new Ubigeo(150101, "Lima", "Lima", "Lima", Arrays.asList(null, null)));

            Ubigeo ubigeo1 = ubigeoRepository.findById(Long.valueOf(1)).get();
            System.out.println("--------------");

            inmuebleRepository.save(new Inmueble("Departamento", "Habitacion Compartida", "Jirón de la Unión 456, Cercado de Lima", 1200.00, 3, 2, 5, 100,"Más de 10 años", Arrays.asList("https://i.postimg.cc/x8VHg1jq/367345008.webp",
                    "https://i.postimg.cc/zXZwJ0rK/367345011.webp",
                    "https://i.postimg.cc/9fRzwHPM/367345009.webp"), "Amplio departamento de 3 dormitorios y 2 baños, ideal para una familia. Ubicada en un vecindario tranquilo y seguro. Cerca de parques y escuelas.", usuario1, ubigeo1));

            inmuebleRepository.save(new Inmueble("Departamento", "Alojamiento Entero", "Calle Los Delfines 123, Urb. Santa Rosa", 750.00, 2, 1, 3, 70,"Menos de 1 año", Arrays.asList("https://i.postimg.cc/KvM9f1Zr/360288971.webp",
                    "https://i.postimg.cc/T1WctsXY/360288974.jpg",
                    "https://i.postimg.cc/mZvxTfkj/360288970.webp"), "Moderno departamento de estreno con 2 dormitorios y 1 baño. Excelente ubicación, cerca de centros comerciales y transporte público.", usuario2, ubigeo1));


            Inmueble inmueble1 = inmuebleRepository.findById(Long.valueOf(1)).get();
            Inmueble inmueble2 = inmuebleRepository.findById(Long.valueOf(2)).get();


        };
    }
}
