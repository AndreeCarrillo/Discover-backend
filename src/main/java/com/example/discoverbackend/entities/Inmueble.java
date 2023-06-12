package com.example.discoverbackend.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "inmuebles")
@Data
@NoArgsConstructor
public class Inmueble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private Double price;
    private Integer numBedrooms;
    private Integer numBathrooms;
    private Integer numGuests;
    private Integer squareMeter;
    private String timeAntiquity;
    private String photoLink;
    private String description;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ubigeo_id")
    private Ubigeo ubigeo;

    @OneToMany (mappedBy = "inmueble", cascade={CascadeType.REMOVE})
    private List<Opinion> opiniones;

    public Inmueble(String address, Double price, Integer numBedrooms, Integer numBathrooms, Integer numGuests, Integer squareMeter, String timeAntiquity, String photoLink, String description, Usuario usuario, Ubigeo ubigeo) {
        this.address = address;
        this.price = price;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.numGuests = numGuests;
        this.squareMeter = squareMeter;
        this.timeAntiquity = timeAntiquity;
        this.photoLink = photoLink;
        this.description = description;
        this.usuario = usuario;
        this.ubigeo = ubigeo;
    }
}
