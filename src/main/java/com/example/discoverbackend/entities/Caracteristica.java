package com.example.discoverbackend.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="caracteristicas")
@Data
@NoArgsConstructor
public class Caracteristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "tipo_caracteristica_id")
    private TipoCaracterisitica tipoCaracterisitica;


}
