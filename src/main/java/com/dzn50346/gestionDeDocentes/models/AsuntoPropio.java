package com.dzn50346.gestionDeDocentes.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "asunto_propio")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AsuntoPropio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asunto_propio")
    private int id;

    @NonNull
    private Date diaSolicitado;
    private String descripcion;

    private LocalDate fechaTramitacion;
    private boolean aprobado;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_docente")
    private Docente docente;

}
