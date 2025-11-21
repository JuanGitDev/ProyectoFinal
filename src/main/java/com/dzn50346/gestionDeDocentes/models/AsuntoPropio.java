package com.dzn50346.gestionDeDocentes.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "asuntoPropio")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AsuntoPropio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "id_asunto_propio")
    private int id;

    private LocalDate diaSolicitado;
    private String descripcion;
    private LocalDate fechaTramitacion;
    private boolean aprobado;

    @ManyToOne
    @JoinColumn(name = "id_docente")
    private Docente docente;

}
