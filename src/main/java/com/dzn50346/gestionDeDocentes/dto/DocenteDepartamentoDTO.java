package com.dzn50346.gestionDeDocentes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DocenteDepartamentoDTO {
    private String nombreDocente;
    private String apellidoDocente;
    private String departamento;
    private String codigoDepartamento;
}
