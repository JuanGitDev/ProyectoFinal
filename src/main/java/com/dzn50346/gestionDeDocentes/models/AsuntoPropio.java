package com.dzn50346.gestionDeDocentes.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

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

    @NonNull
    private Date diaSolicitado;
    private String descripcion;

    @NonNull
    private Date fechaTramitacion;
    private boolean aprobado;

    @ManyToOne
    @JoinColumn(name = "id_docente")
    private Docente docente;

}
