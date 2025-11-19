package com.dzn50346.gestionDeDocentes.horario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "horario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_horario")
    private int id;

    private int dia;
    private int hora;
    private String aula;
}
