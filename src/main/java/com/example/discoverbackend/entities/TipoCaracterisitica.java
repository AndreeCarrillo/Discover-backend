package com.example.discoverbackend.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="tipos_caracteristicas")
@Data
@NoArgsConstructor
public class TipoCaracterisitica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "tipo_caracteristica")
    private List<Caracteristica> caracteristicas;
}
