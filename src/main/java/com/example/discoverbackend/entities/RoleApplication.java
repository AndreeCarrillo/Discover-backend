package com.example.discoverbackend.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "rol")
@Data
@AllArgsConstructor
@NoArgsConstructor
@With
public class RoleApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    public Set<Usuario> users = new HashSet<>();
}
