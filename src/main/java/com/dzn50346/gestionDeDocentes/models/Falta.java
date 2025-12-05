package com.dzn50346.gestionDeDocentes.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "falta")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Falta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_falta")
    private int id;

    private LocalDate fecha;
    private String anotacion;
    private String material;

    @ManyToOne
    @JoinColumn(name = "horario_id")
    private Horario horario;

    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;
}
