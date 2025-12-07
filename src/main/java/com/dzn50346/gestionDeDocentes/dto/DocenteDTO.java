package com.dzn50346.gestionDeDocentes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DocenteDTO {
    private int idDTO;
    private String nombreDTO;
    private String apellidosDTO;
    private String emailDTO;
    private String siglasDTO;
    private String tipoDTO;
    private String antiguedadDTO;
    private int idAsuntoPropioDTO;
    private int idDepartamentoDTO;
    private int idRolDTO;
    private int idHorarioDTO;
    private int idFaltaDTO;

}
