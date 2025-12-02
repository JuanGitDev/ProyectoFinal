package com.dzn50346.gestionDeDocentes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AsuntoPropioDTO {

    private int idDTO;
    private Date diaSolicitadoDTO;
    private String descripcionDTO;
    private Date fechaTramitacionDTO;
    private boolean aprobadoDTO;
    private int idDocenteDTO;

}
