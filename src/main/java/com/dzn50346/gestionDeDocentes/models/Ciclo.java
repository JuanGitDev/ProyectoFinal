package com.dzn50346.gestionDeDocentes.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ciclo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ciclo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "id_ciclo")
    private int id;

    private String nombre;
    private String familia;
    private String codigo;
}
