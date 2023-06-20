package com.example.discoverbackend;

import com.example.discoverbackend.entities.*;
import com.example.discoverbackend.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Arrays;
import java.util.Calendar;
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

        FotoRepository fotoRepository,
        InmuebleFotoRepository inmuebleFotoRepository,
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
            usuarioRepository.save(new Usuario("María",  "Fernández", "Castañeda", "12345697", "912345792", "maria.fernandez@gmail.com", "Maria1234", "https://i.postimg.cc/rstV9z0X/Screenshot-2023-05-01-220903.jpg", "https://i.postimg.cc/1zZvmdcp/photo-1659332589233-3637f89be936.jpg", new Date(95,10,10), new Date(123,04,30), null));
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
            inmuebleRepository.save(new Inmueble("Departamento", "Habitacion Compartida", "Jirón de la Unión 456, Cercado de Lima", 1200.00, 3, 2, 5, 100,"Más de 10 años", "Amplio departamento de 3 dormitorios y 2 baños, ideal para una familia. Ubicada en un vecindario tranquilo y seguro. Cerca de parques y escuelas.", usuario13, ubigeo1));
            inmuebleRepository.save(new Inmueble("Departamento", "Alojamiento Entero", "Calle Los Delfines 123, Urb. Santa Rosa", 750.00, 2, 1, 3, 70,"Menos de 1 año",  "Moderno departamento de estreno con 2 dormitorios y 1 baño. Excelente ubicación, cerca de centros comerciales y transporte público.", usuario7, ubigeo1));
            inmuebleRepository.save(new Inmueble("Casa","Alojamiento Entero", "Av. Separadora Industrial 345, Salamanca",2000.00, 4,3,6, 150,"Más de 20 años",  "Hermosa casa de dos pisos con 4 dormitorios, 3 baños y amplios espacios. Jardín privado y garaje para 2 autos. Ideal para familias grandes.", usuario19, ubigeo1));
            inmuebleRepository.save(new Inmueble("Departamento","Alojamiento Entero", "Calle San Martín 567",900.00, 1,1,2, 50,"Estreno", "Acogedor departamento de estreno con 1 dormitorio y 1 baño. Cuenta con una cocina moderna y una terraza con vista a la ciudad. Ideal para parejas o profesionales.", usuario2, ubigeo1));
            inmuebleRepository.save(new Inmueble("Departamento","Habitacion Compartida", "Av. Bolivia 789",1300.00, 3,2,4, 110,"Más de 5 años",  "Bonito departamento de 3 dormitorios y 2 baños, ubicado en una zona residencial tranquila. Cuenta con áreas comunes como piscina y zona de parrillas.", usuario16, ubigeo1));
            inmuebleRepository.save(new Inmueble("Casa","Habitacion Compartida", "Jirón Los Laureles 112",2200.00, 4,3,8, 180,"Más de 10 años", "Amplia casa de dos pisos con 4 dormitorios, 3 baños y un estudio. Espacios luminosos y cómodos. Ubicada en una zona residencial con vigilancia 24/7.", usuario4, ubigeo1));
            inmuebleRepository.save(new Inmueble("Departamento","Alojamiento Entero", "Calle Los Pinos 123, Urb. La Campiña",1500.00, 2,2,3, 90,"Menos de 1 año",  "Moderno departamento de estreno con 2 dormitorios y 2 baños en edificio con piscina, gimnasio y zona de parrillas. Ubicado cerca de centros comerciales y parques.", usuario11, ubigeo1));
            inmuebleRepository.save(new Inmueble("Departamento","Habitacion Privada", "Av. Nueva Toledo 431",850.00, 1,1,2, 45,"Más de 2 años",  "Acogedor departamento de 1 dormitorio y 1 baño, perfecto para parejas o profesionales. Cuenta con una cocina abierta y un pequeño balcón. Cerca de tiendas y transporte público.", usuario6, ubigeo1));
            inmuebleRepository.save(new Inmueble("Casa","Alojamiento Entero", "Calle Los Alpes 145, Urb. Santa Luzmila",2800.00, 5,4,10, 200,"Más de 20 años",  "Espaciosa casa de dos pisos con 5 dormitorios, 4 baños y un amplio jardín. Ideal para familias numerosas o grupos de amigos. Ubicada en una tranquila calle residencial.", usuario18, ubigeo1));
            inmuebleRepository.save(new Inmueble("Casa","Alojamiento Entero", "Av. Riva Agüero 678",1100.00, 3,2,5, 95,"Más de 5 años",  "Cómodo casa de 3 dormitorios y 2 baños, ideal para familias. Cuenta con una amplia sala y comedor. Ubicado cerca de colegios y áreas verdes.", usuario3, ubigeo1));
            inmuebleRepository.save(new Inmueble("Casa","Habitacion Privada", "Av. Carlos Izaguirre 987",1600.00, 3,3,6, 120,"Estreno",  "Exclusiva casa de estreno con 3 dormitorios y 3 baños. Acabados de lujo, cocina moderna y vista panorámica. Edificio con gimnasio, piscina y seguridad 24/7.", usuario15, ubigeo1));
            inmuebleRepository.save(new Inmueble("Departamento","Habitacion Privada", "Calle San Felipe 890",700.00, 1,1,2, 40,"Más de 10 años", "Departamento acogedor de 1 dormitorio y 1 baño, ideal para estudiantes o profesionales solteros. Cerca de universidades y servicios básicos.", usuario8, ubigeo1));
            inmuebleRepository.save(new Inmueble("Casa","Habitacion Privada", "Calle Los Alamos 135, Urb. Las Praderas",1900.00, 4,3,7, 160,"Más de 40 años", "Encantadora casa de estilo clásico con 4 dormitorios y 3 baños. Espacios amplios y luminosos, con techos altos y detalles arquitectónicos únicos. Ideal para amantes de lo vintage.", usuario9, ubigeo1));
            inmuebleRepository.save(new Inmueble("Casa","Habitacion Privada", "Av. Manco Cápac 543",1400.00, 3,2,5, 105,"Más de 50 años",  "Casa con encanto de 3 dormitorios y 2 baños en un tranquilo barrio residencial. Cuenta con un jardín y un patio trasero. Perfecta para familias que buscan un hogar con carácter y personalidad.", usuario5, ubigeo1));
            inmuebleRepository.save(new Inmueble("Departamento","Habitacion Privada", "Calle Los Olivos 321",1000.00, 2,1,4, 75,"Menos de 1 año", "Departamento moderno de estreno con 2 dormitorios y 1 baño. Ubicado en un edificio con áreas comunes, como gimnasio y terraza. Cerca de centros comerciales y transporte público.", usuario1, ubigeo1));
            inmuebleRepository.save(new Inmueble("Casa","Habitacion Privada", "Calle Los Nogales 654, Urb. El Trébol",2400.00, 5,4,8, 210,"Más de 20 años", "Casa espaciosa de 5 dormitorios y 4 baños, ideal para familias numerosas. Cuenta con una sala de estar, comedor y un amplio jardín. Ubicada en un vecindario seguro y tranquilo.", usuario14, ubigeo1));
            inmuebleRepository.save(new Inmueble("Departamento","Habitacion Privada", "Av. Central 432, San Antonio",950.00, 2,1,3, 65,"Más de 2 años", "Confortable departamento de 2 dormitorios y 1 baño en una ubicación céntrica. A pocos minutos de tiendas, restaurantes y parques. Ideal para parejas o pequeñas familias.", usuario20, ubigeo1));
            inmuebleRepository.save(new Inmueble("Casa","Habitacion Privada", "Av. Lurín 785",1800.00, 4,3,6, 150,"Más de 5 años", "Amplia casa de 4 dormitorios y 3 baños en una tranquila zona residencial. Cuenta con una espaciosa sala de estar, comedor y jardín. Perfecta para familias que buscan comodidad y seguridad.", usuario12, ubigeo1));
            inmuebleRepository.save(new Inmueble("Departamento","Habitacion Privada", "Calle Gonzales Prada 678",1200.00, 3,2,4, 100,"Estreno",  "Moderno y elegante departamento de estreno con 3 dormitorios y 2 baños. Cuenta con una amplia cocina y un balcón con vista al parque. Edificio con áreas comunes y seguridad 24/7.", usuario7, ubigeo1));
            inmuebleRepository.save(new Inmueble("","", "Jr. La honestida",500.00, 4,2,5, 140,"Menos de 1 año", "Como apartamento", usuario18, ubigeo1));


            Inmueble inmueble1 = inmuebleRepository.findById(Long.valueOf(1)).get();
            Inmueble inmueble2 = inmuebleRepository.findById(Long.valueOf(2)).get();
            Inmueble inmueble3 = inmuebleRepository.findById(Long.valueOf(3)).get();
            Inmueble inmueble4 = inmuebleRepository.findById(Long.valueOf(4)).get();
            Inmueble inmueble5 = inmuebleRepository.findById(Long.valueOf(5)).get();
            Inmueble inmueble6 = inmuebleRepository.findById(Long.valueOf(6)).get();
            Inmueble inmueble7 = inmuebleRepository.findById(Long.valueOf(7)).get();
            Inmueble inmueble8 = inmuebleRepository.findById(Long.valueOf(8)).get();
            Inmueble inmueble9 = inmuebleRepository.findById(Long.valueOf(9)).get();
            Inmueble inmueble10 = inmuebleRepository.findById(Long.valueOf(10)).get();
            Inmueble inmueble11 = inmuebleRepository.findById(Long.valueOf(11)).get();
            Inmueble inmueble12 = inmuebleRepository.findById(Long.valueOf(12)).get();
            Inmueble inmueble13 = inmuebleRepository.findById(Long.valueOf(13)).get();
            Inmueble inmueble14 = inmuebleRepository.findById(Long.valueOf(14)).get();
            Inmueble inmueble15 = inmuebleRepository.findById(Long.valueOf(15)).get();
            Inmueble inmueble16 = inmuebleRepository.findById(Long.valueOf(16)).get();
            Inmueble inmueble17 = inmuebleRepository.findById(Long.valueOf(17)).get();
            Inmueble inmueble18 = inmuebleRepository.findById(Long.valueOf(18)).get();
            Inmueble inmueble19 = inmuebleRepository.findById(Long.valueOf(19)).get();
            Inmueble inmueble20 = inmuebleRepository.findById(Long.valueOf(20)).get();

            System.out.println("--------------");


            fotoRepository.save(new Foto("https://i.postimg.cc/x8VHg1jq/367345008.webp"));
            fotoRepository.save(new Foto("https://i.postimg.cc/zXZwJ0rK/367345011.webp"));
            fotoRepository.save(new Foto("https://i.postimg.cc/9fRzwHPM/367345009.webp"));

            fotoRepository.save(new Foto("https://i.postimg.cc/KvM9f1Zr/360288971.webp"));
            fotoRepository.save(new Foto("https://i.postimg.cc/T1WctsXY/360288974.jpg"));
            fotoRepository.save(new Foto("https://i.postimg.cc/mZvxTfkj/360288970.webp"));

            fotoRepository.save(new Foto("https://i.postimg.cc/258M0C9k/364654991.jpg"));
            fotoRepository.save(new Foto("https://i.postimg.cc/qRNYdjdW/364654992.jpg"));
            fotoRepository.save(new Foto("https://i.postimg.cc/wTXrH1Sx/364654996.webp"));

            fotoRepository.save(new Foto("https://i.postimg.cc/FRkP6zy4/345316152.webp"));
            fotoRepository.save(new Foto("https://i.postimg.cc/L5MV0T4t/345316147.webp"));
            fotoRepository.save(new Foto("https://i.postimg.cc/htG1whn5/345316151.webp"));

            fotoRepository.save(new Foto("https://i.postimg.cc/50JHhkv2/367715337.webp"));
            fotoRepository.save(new Foto("https://i.postimg.cc/bJqJCScG/367715330.webp"));
            fotoRepository.save(new Foto("https://i.postimg.cc/ZKXqkMzz/345316140.jpg"));

            fotoRepository.save(new Foto("https://i.postimg.cc/3xSQ5yv4/367321952.webp"));
            fotoRepository.save(new Foto("https://i.postimg.cc/cCMPD6WJ/367321961.webp"));
            fotoRepository.save(new Foto("https://i.postimg.cc/9FbvZ418/367321956.webp"));

            fotoRepository.save(new Foto("https://i.postimg.cc/K8dQMxXp/339288566.jpg"));
            fotoRepository.save(new Foto("https://i.postimg.cc/fLMccb8C/346415581.jpg"));
            fotoRepository.save(new Foto("https://i.postimg.cc/cCbfGB0k/361164698.webp"));

            fotoRepository.save(new Foto("https://i.postimg.cc/43Wd0NJB/363145161.webp"));
            fotoRepository.save(new Foto("https://i.postimg.cc/1zmckHFP/363145172.webp"));
            fotoRepository.save(new Foto("https://i.postimg.cc/ZRg8yzMK/363145169.webp"));

            fotoRepository.save(new Foto("https://i.postimg.cc/W1XJkPDL/273805402.webp"));
            fotoRepository.save(new Foto("https://i.postimg.cc/3N5yT8qp/273805399.webp"));
            fotoRepository.save(new Foto("https://i.postimg.cc/hPnJZGTR/273805396.webp"));

            fotoRepository.save(new Foto("https://i.postimg.cc/XJwj9w2G/243716601.jpg"));
            fotoRepository.save(new Foto("https://i.postimg.cc/7h9qWqrq/243716590.jpg"));
            fotoRepository.save(new Foto("https://i.postimg.cc/W1hs5RWP/243716589.jpg"));

            fotoRepository.save(new Foto("https://i.postimg.cc/BQw0LYq7/361633141.jpg"));
            fotoRepository.save(new Foto("https://i.postimg.cc/CxBVjG5h/361633140.jpg"));
            fotoRepository.save(new Foto("https://i.postimg.cc/0N7R497h/361633142.jpg"));

            fotoRepository.save(new Foto("https://i.postimg.cc/XNsMmHyN/367737000.webp"));
            fotoRepository.save(new Foto("https://i.postimg.cc/mrYJw8ss/367737013.jpg"));
            fotoRepository.save(new Foto("https://i.postimg.cc/Y98Vc00D/367737015.jpg"));

            fotoRepository.save(new Foto("https://i.postimg.cc/pdJc8rfV/364365708.jpg"));
            fotoRepository.save(new Foto("https://i.postimg.cc/gcTS3fZh/364365675.jpg"));
            fotoRepository.save(new Foto("https://i.postimg.cc/J4HTxPN2/364365700.jpg"));

            fotoRepository.save(new Foto("https://i.postimg.cc/PrVwxtJ9/SALA-COMEDOR-1.jpg"));
            fotoRepository.save(new Foto("https://i.postimg.cc/1tYHcqfS/367132600.jpg"));
            fotoRepository.save(new Foto("https://i.postimg.cc/cHjz1j7f/367132599.jpg"));

            fotoRepository.save(new Foto("https://i.postimg.cc/Nj4P2L7s/357173625.jpg"));
            fotoRepository.save(new Foto("https://i.postimg.cc/259cTJKg/357173631.webp"));
            fotoRepository.save(new Foto("https://i.postimg.cc/Y0YdrSCw/357173633.webp"));

            fotoRepository.save(new Foto("https://i.postimg.cc/zvxVRCBw/359977702.jpg"));
            fotoRepository.save(new Foto("https://i.postimg.cc/QMcCqGCd/359971433.webp"));

            fotoRepository.save(new Foto( "https://i.postimg.cc/wx4qLT2k/366593944.jpg"));
            fotoRepository.save(new Foto("https://i.postimg.cc/3xmYsjTL/366593940.jpg"));
            fotoRepository.save(new Foto("https://i.postimg.cc/9fBVMWzZ/366593930.jpg"));

            fotoRepository.save(new Foto("https://i.postimg.cc/zGCYtJC6/362152449.jpg"));
            fotoRepository.save(new Foto( "https://i.postimg.cc/d11MVrbc/362152453.webp"));
            fotoRepository.save(new Foto("https://i.postimg.cc/sX0kQ1zQ/362152456.webp"));

            fotoRepository.save(new Foto("https://i.postimg.cc/CKMMbZ3m/364014549.webp"));
            fotoRepository.save(new Foto("https://i.postimg.cc/FKqt17Nf/364014536.jpg"));
            fotoRepository.save(new Foto("https://i.postimg.cc/m2S0CdTW/364014535.jpg"));

            fotoRepository.save(new Foto("https://i.postimg.cc/CKMMbZ3m/364014549.webp"));
            fotoRepository.save(new Foto("https://i.postimg.cc/FKqt17Nf/364014536.jpg"));
            fotoRepository.save(new Foto("https://i.postimg.cc/m2S0CdTW/364014535.jpg"));

            Foto foto1 = fotoRepository.findById(Long.valueOf(1)).get();
            Foto foto2 = fotoRepository.findById(Long.valueOf(2)).get();
            Foto foto3 = fotoRepository.findById(Long.valueOf(3)).get();
            Foto foto4 = fotoRepository.findById(Long.valueOf(4)).get();
            Foto foto5 = fotoRepository.findById(Long.valueOf(5)).get();
            Foto foto6 = fotoRepository.findById(Long.valueOf(6)).get();
            Foto foto7 = fotoRepository.findById(Long.valueOf(7)).get();
            Foto foto8 = fotoRepository.findById(Long.valueOf(8)).get();
            Foto foto9 = fotoRepository.findById(Long.valueOf(9)).get();
            Foto foto10 = fotoRepository.findById(Long.valueOf(10)).get();
            Foto foto11 = fotoRepository.findById(Long.valueOf(11)).get();
            Foto foto12 = fotoRepository.findById(Long.valueOf(12)).get();
            Foto foto13 = fotoRepository.findById(Long.valueOf(13)).get();
            Foto foto14 = fotoRepository.findById(Long.valueOf(14)).get();
            Foto foto15 = fotoRepository.findById(Long.valueOf(15)).get();
            Foto foto16 = fotoRepository.findById(Long.valueOf(16)).get();
            Foto foto17 = fotoRepository.findById(Long.valueOf(17)).get();
            Foto foto18 = fotoRepository.findById(Long.valueOf(18)).get();
            Foto foto19 = fotoRepository.findById(Long.valueOf(19)).get();
            Foto foto20 = fotoRepository.findById(Long.valueOf(20)).get();
            Foto foto21 = fotoRepository.findById(Long.valueOf(21)).get();
            Foto foto22 = fotoRepository.findById(Long.valueOf(22)).get();
            Foto foto23 = fotoRepository.findById(Long.valueOf(23)).get();
            Foto foto24 = fotoRepository.findById(Long.valueOf(24)).get();
            Foto foto25 = fotoRepository.findById(Long.valueOf(25)).get();
            Foto foto26 = fotoRepository.findById(Long.valueOf(26)).get();
            Foto foto27 = fotoRepository.findById(Long.valueOf(27)).get();
            Foto foto28 = fotoRepository.findById(Long.valueOf(28)).get();
            Foto foto29 = fotoRepository.findById(Long.valueOf(29)).get();
            Foto foto30 = fotoRepository.findById(Long.valueOf(30)).get();
            Foto foto31 = fotoRepository.findById(Long.valueOf(31)).get();
            Foto foto32 = fotoRepository.findById(Long.valueOf(32)).get();
            Foto foto33 = fotoRepository.findById(Long.valueOf(33)).get();
            Foto foto34 = fotoRepository.findById(Long.valueOf(34)).get();
            Foto foto35 = fotoRepository.findById(Long.valueOf(35)).get();
            Foto foto36 = fotoRepository.findById(Long.valueOf(36)).get();
            Foto foto37 = fotoRepository.findById(Long.valueOf(37)).get();
            Foto foto38 = fotoRepository.findById(Long.valueOf(38)).get();
            Foto foto39 = fotoRepository.findById(Long.valueOf(39)).get();
            Foto foto40 = fotoRepository.findById(Long.valueOf(40)).get();
            Foto foto41 = fotoRepository.findById(Long.valueOf(41)).get();
            Foto foto42 = fotoRepository.findById(Long.valueOf(42)).get();
            Foto foto43 = fotoRepository.findById(Long.valueOf(43)).get();
            Foto foto44 = fotoRepository.findById(Long.valueOf(44)).get();
            Foto foto45 = fotoRepository.findById(Long.valueOf(45)).get();
            Foto foto46 = fotoRepository.findById(Long.valueOf(46)).get();
            Foto foto47 = fotoRepository.findById(Long.valueOf(47)).get();
            Foto foto48 = fotoRepository.findById(Long.valueOf(48)).get();
            Foto foto49 = fotoRepository.findById(Long.valueOf(49)).get();
            Foto foto50 = fotoRepository.findById(Long.valueOf(50)).get();
            Foto foto51 = fotoRepository.findById(Long.valueOf(51)).get();
            Foto foto52 = fotoRepository.findById(Long.valueOf(52)).get();
            Foto foto53 = fotoRepository.findById(Long.valueOf(53)).get();
            Foto foto54 = fotoRepository.findById(Long.valueOf(54)).get();
            Foto foto55 = fotoRepository.findById(Long.valueOf(55)).get();
            Foto foto56 = fotoRepository.findById(Long.valueOf(56)).get();
            Foto foto57 = fotoRepository.findById(Long.valueOf(57)).get();
            Foto foto58 = fotoRepository.findById(Long.valueOf(58)).get();
            Foto foto59 = fotoRepository.findById(Long.valueOf(59)).get();



            inmuebleFotoRepository.save(new InmuebleFoto(inmueble1, foto1));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble1, foto2));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble1, foto3));

            inmuebleFotoRepository.save(new InmuebleFoto(inmueble2, foto4));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble2, foto5));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble2, foto6));

            inmuebleFotoRepository.save(new InmuebleFoto(inmueble3, foto7));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble3, foto8));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble3, foto9));

            inmuebleFotoRepository.save(new InmuebleFoto(inmueble4, foto10));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble4, foto11));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble4, foto12));

            inmuebleFotoRepository.save(new InmuebleFoto(inmueble5, foto13));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble5, foto14));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble5, foto15));

            inmuebleFotoRepository.save(new InmuebleFoto(inmueble6, foto16));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble6, foto17));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble6, foto18));

            inmuebleFotoRepository.save(new InmuebleFoto(inmueble7, foto19));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble7, foto20));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble7, foto21));

            inmuebleFotoRepository.save(new InmuebleFoto(inmueble8, foto22));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble8, foto23));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble8, foto24));

            inmuebleFotoRepository.save(new InmuebleFoto(inmueble9, foto25));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble9, foto26));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble9, foto27));

            inmuebleFotoRepository.save(new InmuebleFoto(inmueble10, foto28));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble10, foto29));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble10, foto30));

            inmuebleFotoRepository.save(new InmuebleFoto(inmueble11, foto32));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble11, foto33));

            inmuebleFotoRepository.save(new InmuebleFoto(inmueble12, foto34));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble12, foto35));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble12, foto36));

            inmuebleFotoRepository.save(new InmuebleFoto(inmueble12, foto37));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble12, foto38));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble12, foto39));

            inmuebleFotoRepository.save(new InmuebleFoto(inmueble12, foto40));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble12, foto41));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble12, foto42));

            inmuebleFotoRepository.save(new InmuebleFoto(inmueble13, foto43));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble13, foto44));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble13, foto45));

            inmuebleFotoRepository.save(new InmuebleFoto(inmueble14, foto46));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble14, foto47));


            inmuebleFotoRepository.save(new InmuebleFoto(inmueble15, foto49));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble15, foto50));


            inmuebleFotoRepository.save(new InmuebleFoto(inmueble16, foto52));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble16, foto53));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble16, foto54));

            inmuebleFotoRepository.save(new InmuebleFoto(inmueble17, foto55));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble17, foto56));

            inmuebleFotoRepository.save(new InmuebleFoto(inmueble18, foto57));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble18, foto58));

            inmuebleFotoRepository.save(new InmuebleFoto(inmueble19, foto59));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble19, foto51));

            inmuebleFotoRepository.save(new InmuebleFoto(inmueble20, foto48));
            inmuebleFotoRepository.save(new InmuebleFoto(inmueble20, foto31));

            System.out.println("--------------");

            alquilerRepository.save(new Alquiler(usuario1, inmueble1, 1100D, new Date(121, Calendar.APRIL, 1), false));
            alquilerRepository.save(new Alquiler(usuario3, inmueble3, 1950D, new Date(122,   Calendar.JUNE, 21), false));
            alquilerRepository.save(new Alquiler(usuario4, inmueble4, 900D, new Date(120,    Calendar.MARCH, 24), false));
            alquilerRepository.save(new Alquiler(usuario5, inmueble5, 1100D, new Date(121,   Calendar.MARCH, 15), false));
            alquilerRepository.save(new Alquiler(usuario8, inmueble8, 1400D, new Date(122,   Calendar.DECEMBER, 2), false));
            alquilerRepository.save(new Alquiler(usuario10, inmueble10, 2500D, new Date(123, Calendar.MARCH, 7), true));
            alquilerRepository.save(new Alquiler(usuario11, inmueble11, 1100D, new Date(123, Calendar.APRIL, 15), true));
            alquilerRepository.save(new Alquiler(usuario12, inmueble12, 1600D, new Date(122, Calendar.OCTOBER, 19), false));
            alquilerRepository.save(new Alquiler(usuario13, inmueble13, 700D, new Date(121,  Calendar.AUGUST,24), false));
            alquilerRepository.save(new Alquiler(usuario15, inmueble15, 1300D, new Date(123, Calendar.MARCH, 9), true));
            alquilerRepository.save(new Alquiler(usuario18, inmueble18, 900D, new Date(122,  Calendar.JANUARY,30), false));
            alquilerRepository.save(new Alquiler(usuario20, inmueble20, 1100D, new Date(122, Calendar.JULY, 2), false));

        };
    }
}
