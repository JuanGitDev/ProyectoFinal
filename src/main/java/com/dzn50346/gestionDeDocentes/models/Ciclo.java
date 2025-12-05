package com.dzn50346.gestionDeDocentes.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ciclo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Ciclo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "id_ciclo")
    private int id;

    private String nombre;
    private String familia;
    private String codigo;

    @OneToMany(mappedBy = "ciclo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asignatura> asignaturas = new ArrayList<>();
}
