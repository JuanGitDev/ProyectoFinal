package com.dzn50346.gestionDeDocentes.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rol")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_rol")
    private int id;

    private String nombre;
    private int orden;

    @OneToMany(mappedBy = "rol")
    private List<Docente> docentes = new ArrayList<>();
}
