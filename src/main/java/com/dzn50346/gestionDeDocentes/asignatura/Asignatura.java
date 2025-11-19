package com.dzn50346.gestionDeDocentes.asignatura;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}
