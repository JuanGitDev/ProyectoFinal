package com.dzn50346.gestionDeDocentes.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "horario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_horario")
    private int id;

    private int dia;
    private int hora;
    private String aula;

    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "asignatura_id")
    private Asignatura asignatura;

    @OneToMany(mappedBy = "horario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Falta> faltas = new ArrayList<>();
}
