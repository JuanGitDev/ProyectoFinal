package com.dzn50346.gestionDeDocentes.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "horario_id")
    private Horario horario;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;
}
