package com.dzn50346.gestionDeDocentes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AsignaturaDTO {

    private int idDTO;
    private String nombreDTO;
    private String codigoDTO;
    private int horasSemanalesDTO;
}
