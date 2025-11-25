package com.dzn50346.gestionDeDocentes.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "asignatura")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_asignatura")
    private int id;

    private String nombre;
    private String codigo;
    private int horasSemanales;

    @OneToMany(mappedBy = "asignatura")
    private List<Horario> horarios = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "ciclo_id")
    private Ciclo ciclo;
}
