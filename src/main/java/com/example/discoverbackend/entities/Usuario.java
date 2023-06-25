package com.example.discoverbackend.entities;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="usuarios")
@Data
@NoArgsConstructor
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastNameDad;
    private String lastNameMom;
    private String dni;
    private String telephone;
    private String email;
    private String password;
    private String linkPhotoDni;
    private String linkPhotoProfile;
    private Date dateBirth;
    private Date dateAffiliation;

    @OneToMany (mappedBy = "usuario", cascade={CascadeType.REMOVE})
    private List<Inmueble> inmuebles;

    @OneToMany (mappedBy = "client", cascade={CascadeType.REMOVE})
    private List<Opinion> opiniones;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_rol",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Set<RoleApplication> roles = new HashSet<>();

    public Set<String> getRolName() {
        Set<String> rolesName = new HashSet<>();

        roles.forEach(role -> {
            rolesName.add(role.getName());
        });

        return rolesName;
    }

    public Usuario(String firstName, String lastNameDad, String lastNameMom, String dni, String telephone, String email, String password, String linkPhotoDni, String linkPhotoProfile, Date dateBirth, Date dateAffiliation, List<Inmueble> inmuebles) {
        this.firstName = firstName;
        this.lastNameDad = lastNameDad;
        this.lastNameMom = lastNameMom;
        this.dni = dni;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
        this.linkPhotoDni = linkPhotoDni;
        this.linkPhotoProfile = linkPhotoProfile;
        this.dateBirth = dateBirth;
        this.dateAffiliation = dateAffiliation;
        this.inmuebles = inmuebles;
    }
}
