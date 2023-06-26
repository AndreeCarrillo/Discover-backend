package com.example.discoverbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlquilerRequest {

    private String location; //Ubicación
    private String fullNameOwner; //Nombre completo del propietario
    private Double price; //Precio alquiler
    private Date transactionDate; //Fecha transacción
    private Boolean active; //Alquiler activo
    private Long property_id; //Inmueble ID

}