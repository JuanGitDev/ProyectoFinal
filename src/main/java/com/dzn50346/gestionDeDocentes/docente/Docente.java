package com.dzn50346.gestionDeDocentes.docente;

import com.dzn50346.gestionDeDocentes.asuntoPropio.AsuntoPropio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "docentes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

}
