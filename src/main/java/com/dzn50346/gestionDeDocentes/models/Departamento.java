package com.dzn50346.gestionDeDocentes.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "departamento")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "id_departamento")
    private int id;

    private String nombre;
    private String codigo;
    private String telefono;

    @OneToMany(mappedBy = "departamento")
    private List<Docente> docentes = new ArrayList<>();
}
