package com.dzn50346.gestionDeDocentes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AsuntoPropioDTO {

    private int idDTO;
    private String diaSolicitadoDTO;
    private String descripcionDTO;
    private String fechaTramitacionDTO;
    private boolean aprobadoDTO;
    private int idDocenteDTO;

}
