package com.example.discoverbackend.entities;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="caracteristicas")
@Data
@NoArgsConstructor
public class Caracteristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @ManyToOne
    @JoinColumn(name = "tipo_caracteristica_id")
    private TipoCaracteristica tipoCaracteristica;


    public Caracteristica(String name, TipoCaracteristica tipoCaracteristica) {
        this.name = name;
        this.tipoCaracteristica = tipoCaracteristica;
    }
}
