package com.dzn50346.gestionDeDocentes.rol;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rol")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_rol")
    private int id;

    private String nombre;
    private int orden;
}
