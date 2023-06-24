package com.example.discoverbackend.entities;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="opiniones")
@Data
@NoArgsConstructor
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "inmueble_id")
    private Inmueble inmueble;

    private Integer calificacion;
    private String observaciones;
    private String linkFoto;

    public Opinion(Usuario usuario, Inmueble inmueble, Integer calificacion, String observaciones, String linkFoto) {
        this.usuario = usuario;
        this.inmueble = inmueble;
        this.calificacion = calificacion;
        this.observaciones = observaciones;
        this.linkFoto = linkFoto;
    }
}
