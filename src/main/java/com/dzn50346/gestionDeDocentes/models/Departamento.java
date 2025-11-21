package com.dzn50346.gestionDeDocentes.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "departamento")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
