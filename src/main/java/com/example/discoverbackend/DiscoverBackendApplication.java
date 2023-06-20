package com.example.discoverbackend;

import com.example.discoverbackend.entities.*;
import com.example.discoverbackend.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.text.SimpleDateFormat;
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
        UbigeoRepository ubigeoRepository,
        AlquilerRepository alquilerRepository
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

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            usuarioRepository.save(new Usuario("Vanessa", "Castillo", "Gomes", "43451826", "901023352","vanessa.castillo@gmail.com","vanessa_2kamx","https://i.postimg.cc/6QN9f9wF/documento-identidad-peru-vanessa.jpg","https://i.postimg.cc/15qXG7wn/Screenshot-2023-05-01-220937.jpg", formatter.parse("1995-09-12"), formatter.parse("2023-03-14"), null));
            usuarioRepository.save(new Usuario("Carlos", "Rodríguez","Salas", "23456789", "901012352", "carlos.rodriguez@outlook.com", "Carlos1234", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg","https://i.postimg.cc/nL8PsrZ9/hombre-foto.jpg", new Date(85,05,15), new Date(123,04,02), null ));
            usuarioRepository.save(new Usuario("Fernanda","Gómez", "Vargas","34567890","345678921","fernanda.gomez@yahoo.com","Fernanda1234","https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg","https://i.postimg.cc/BZc4JWTC/retrato-de-joven-feliz-positivo-sonriendo-c-mara-166576783.jpg", new Date(92,10,30), new Date(2023,04,05),null));
            usuarioRepository.save(new Usuario("Miguel",  "Sánchez", "Ortiz", "12345696", "923457822", "miguel.sanchez@outlook.com", "Miguel1234", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/qqgLDH4d/inline-image-preview.jpg", new Date(80,12,20), new Date(123,04,29), null));
            usuarioRepository.save(new Usuario("María",  "Fernández", "Castañeda", "12345697", "912345792", "maria.fernandez@gmail.com", "Maria1234", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/1zZvmdcp/photo-1659332589233-3637f89be936.jpg", new Date(95,10,10), new Date(2023,04,30), null));
            usuarioRepository.save(new Usuario("Juan",  "Perez", "Paz", "12345678", "987654321", "juan.perez@gmail.com", "Juan1234", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/zXb7nNxC/istockphoto-1212501093-640x640.jpg", new Date(95,10,15), new Date(122,1,1), null));
            usuarioRepository.save(new Usuario("María",  "López", "Vázquez", "87654321", "765432109", "maria.lopez@example.com", "Maria5678", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/zDcZzJLK/women-i-am-young-girls-beautiful.jpg", new Date(1990,2,12), new Date(122,03,15), null));
            usuarioRepository.save(new Usuario("Pedro",  "Ramírez", "Gutiérrez", "98765432", "876543210", "pedro.ramirez@example.com", "Pedro9012", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/6Q0f9pQX/happy-smile-face.jpg", new Date(85,05,20), new Date(122,05,10), null));
            usuarioRepository.save(new Usuario("Luis",  "Gonzales", "Vargas", "34567891", "987654321", "luis.gonzales@example.com", "Luis4567", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/Rh37Q1LS/pexels-photo-6421292.jpg", new Date(88,07,20), new Date(122,06,05), null));
            usuarioRepository.save(new Usuario("Mónica",  "Díaz", "López", "45678912", "987654321", "monica.diaz@example.com", "Monica8910", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/q7k2ZHxZ/concepto-de-bienestar-y-personas-cierre-una-atractiva-rubia-sonriendo-con-dientes-blancos-mirando-la.jpg", new Date(93,02,18), new Date(122,9,01), null));
            usuarioRepository.save(new Usuario("Jorge",  "Flores", "Castro", "56789123", "947654321", "jorge.flores@example.com", "Jorge2345", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://example.com/foto_perfil.jpg", new Date(98,11,28), new Date(2022,10,15), null));
            usuarioRepository.save(new Usuario("Carmen",  "Guzmán", "Ramírez", "67891234", "987624321", "carmen.guzman@example.com", "Carmen3456", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/44K21pdH/personas-reales-feliz-chica-natural-sonriendo-y-mirando-t-mido-la-c-mara-ruboriz-ndose-de-halagos-pi.jpg", new Date(80,06,05), new Date(122,11,1), null));
            usuarioRepository.save(new Usuario("Antonio",  "Vega", "López", "78912345", "907654817", "antonio.vega@example.com", "Antonio7890", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/j5n6yQXs/joven-dispara-con-su-c-mara-retrato-de-un-asi-tico-gracioso-tomando-fotos-disparando-fot-grafo-casua.jpg", new Date(91,03,14), new Date(123,01,15), null));
            usuarioRepository.save(new Usuario("Sofía",  "Mendoza", "Gómez", "89123456", "917653021", "sofia.mendoza@example.com", "Sofia5678", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/Y9vRbwpB/portrait-people-cute-girl-smile.jpg", new Date(97,9,20), new Date(2023,03,01), null));
            usuarioRepository.save(new Usuario("Miguel",  "Castillo", "Hernández", "91234567", "985657311", "miguel.castillo@example.com", "Miguel1234", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/Gm3kX1Qg/man-person-portrait-sitting-smile-smiling-wear-looking-at-camera-one-person-real-people.jpg", new Date(92,12,10), new Date(123,04,15), null));
            usuarioRepository.save(new Usuario("Laura",  "Martínez", "Vargas", "34567891", "957354001", "laura.martinez@example.com", "Laura5678", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/9McV7JV9/female-indian-young-girl-woman-people.jpg", new Date(87,3,5), new Date(123,06,01), null));
            usuarioRepository.save(new Usuario("Lorena",  "Hernández", "Sánchez", "45678912", "922654321", "lorena.hernandez@example.com", "Lorena9012", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/zXxLXHCp/istockphoto-1443543154-170667a.jpg", new Date(95,8,2), new Date(123,8,15), null));
            usuarioRepository.save(new Usuario("Javier",  "González", "Morales", "56789123", "917654451", "javier.gonzalez@example.com", "Javier3456", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/0yJ8Rzcz/pexels-photo-5215015.jpg", new Date(84,11,12), new Date(123,10,12), null));
            usuarioRepository.save(new Usuario("Marisol",  "Sánchez", "López", "67891234", "981234321", "marisol.sanchez@example.com", "Marisol1234", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/J01nRRt9/sonriente-mujer-bonita-joven-mirando-camara-tocar-cara-1262-15253.jpg", new Date(90,06,18), new Date(123,11,01), null));
            usuarioRepository.save(new Usuario("Gustavo",  "García", "Pérez", "78912345", "987111321", "gustavo.garcia@example.com", "Gustavo5678", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/SRNywVv4/person-smiling.jpg", new Date(82,9,28), new Date(123,12,15), null));





            Usuario usuario1 = usuarioRepository.findById(Long.valueOf(1)).get();
            Usuario usuario2 = usuarioRepository.findById(Long.valueOf(2)).get();
            Usuario usuario3 = usuarioRepository.findById(Long.valueOf(3)).get();
            Usuario usuario4 = usuarioRepository.findById(Long.valueOf(4)).get();
            Usuario usuario5 = usuarioRepository.findById(Long.valueOf(5)).get();
            Usuario usuario6 = usuarioRepository.findById(Long.valueOf(6)).get();
            Usuario usuario7 = usuarioRepository.findById(Long.valueOf(7)).get();
            Usuario usuario8 = usuarioRepository.findById(Long.valueOf(8)).get();
            Usuario usuario9 = usuarioRepository.findById(Long.valueOf(9)).get();
            Usuario usuario10 = usuarioRepository.findById(Long.valueOf(10)).get();
            Usuario usuario11 = usuarioRepository.findById(Long.valueOf(11)).get();
            Usuario usuario12 = usuarioRepository.findById(Long.valueOf(12)).get();
            Usuario usuario13 = usuarioRepository.findById(Long.valueOf(13)).get();
            Usuario usuario14 = usuarioRepository.findById(Long.valueOf(14)).get();
            Usuario usuario15 = usuarioRepository.findById(Long.valueOf(15)).get();
            Usuario usuario16 = usuarioRepository.findById(Long.valueOf(16)).get();
            Usuario usuario17 = usuarioRepository.findById(Long.valueOf(17)).get();
            Usuario usuario18 = usuarioRepository.findById(Long.valueOf(18)).get();
            Usuario usuario19 = usuarioRepository.findById(Long.valueOf(19)).get();
            Usuario usuario20 = usuarioRepository.findById(Long.valueOf(20)).get();



            System.out.println("--------------");

            //alquilerrepositories

            System.out.println("--------------");

            ubigeoRepository.save(new Ubigeo(150101, "Lima", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150102, "Ancon", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150103, "Ate", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150104, "Barranco", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150105, "Breña", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150106, "Carabayllo", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150107, "Chaclacayo", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150108, "Chorrillos", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150109, "Cieneguilla", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150110, "Comas", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150111, "El Agustino", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150112, "Independencia", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150113, "Jesus Maria", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150114, "La Molina", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150115, "La Victoria", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150116, "Lince", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150117, "Los Olivos", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150118, "Lurigancho", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150119, "Lurin", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150120, "Magdalena del Mar", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150121, "Miraflores", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150122, "Pachacamac", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150123, "Pucusana", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150124, "Pueblo Libre", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150125, "Puente Piedra", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150126, "Punta Hermosa", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150127, "Punta Negra", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150128, "Rimac", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150129, "San Bartolo", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150130, "San Borja", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150131, "San Isidro", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150132, "San Juan de Lurigancho", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150133, "San Juan de Miraflores", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150134, "San Luis", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150135, "San Martin de Porres", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150136, "San Miguel", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150137, "Santa Anita", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150138, "Santa Maria del Mar", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150139, "Santa Rosa", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150140, "Santiago de Surco", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150141, "Surquillo", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150142, "Villa El Salvador", "Lima", "Lima", Arrays.asList(null, null)));
            ubigeoRepository.save(new Ubigeo(150143, "Villa Maria del Triunfo", "Lima", "Lima", Arrays.asList(null, null)));


            Ubigeo ubigeo1 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo2 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo3 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo4 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo5 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo6 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo7 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo8 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo9 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo10 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo11 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo12 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo13 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo14 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo15 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo16 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo17 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo18 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo19 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo20 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo21 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo22 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo23 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo24 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo25 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo26 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo27 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo28 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo29 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo30 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo31 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo32 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo33 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo34 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo35 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo36 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo37 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo38 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo39 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo40 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo41 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo42 = ubigeoRepository.findById(1L).get();
            Ubigeo ubigeo43 = ubigeoRepository.findById(1L).get();

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
