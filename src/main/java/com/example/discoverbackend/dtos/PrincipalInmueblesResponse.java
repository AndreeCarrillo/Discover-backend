package com.example.discoverbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrincipalInmueblesResponse {

    private String linkPhotoUser;
    private String fullName;
    private String province;
    private String department;
    private String district;
    private String linkPhotoProperty;
    private Double price;
    private Integer squareMeter;
    private Integer numBedrooms;
    private Integer numBathrooms;
    private String description;
}
