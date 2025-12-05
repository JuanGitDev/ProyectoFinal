package com.dzn50346.gestionDeDocentes.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "docentes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Docente {
    @Id
    @Column(name = "id_docente")
    private int id;

    private String nombre;
    private String apellidos;
    private String email;
    private String siglas;
    private String tipo;
    private LocalDate antiguedad;
    private int posicion;

    @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AsuntoPropio> asuntosPropios = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departamento_id", referencedColumnName = "id_departamento")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

    @OneToMany(mappedBy = "docente")
    private List<Horario> horarios = new ArrayList<>();

    @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Falta> faltasRegistradas = new ArrayList<>();

}
