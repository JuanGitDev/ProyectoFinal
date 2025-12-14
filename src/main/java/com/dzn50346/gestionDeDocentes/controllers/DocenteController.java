package com.dzn50346.gestionDeDocentes.controllers;

import com.dzn50346.gestionDeDocentes.dto.DocenteDTO;
import com.dzn50346.gestionDeDocentes.dto.DocenteDepartamentoDTO;
import com.dzn50346.gestionDeDocentes.services.DocenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/gestionDocente/api/docente")
public class DocenteController {

    private final DocenteService service;

    public DocenteController(DocenteService service) {
        this.service = service;
    }

    @GetMapping(path = "/mostrarDocentes")
    public List<DocenteDTO> mostrarDocentes() {
        return service.mostrarDocentes();
    }

    @GetMapping(path = "/docentesConDepartamentos")
    public List<DocenteDepartamentoDTO> mostrarDocenteConDepartamento() {
        return service.mostrarDocentesConDepto();
    }

    @GetMapping(path = "/ordenadosPorApellidos")
    public List<DocenteDTO> mostrarDocentesOrdenadoPorApellidos() {
        return service.getDocentesOrdenadosPorApellidos();
    }

    @GetMapping(path = "/porDepartamento/{nombreDepto}")
    public List<DocenteDTO> getDocentesPorDepartamento(@PathVariable String nombreDepto) {
        return service.getDocentesPorDepartamento(nombreDepto);
    }

    @GetMapping(path = "/departamento/{codigoDepto}/numeroDocentes")
    public long getNumeroDocentesPorDepartamento(@PathVariable String codigoDepto) {
        return service.getNumeroDocentesPorDepartamento(codigoDepto);
    }

    @GetMapping(path = "/conMasAsuntosPropios")
    public ResponseEntity<DocenteDTO> getDocenteConMasAsuntosPropiosDisfrutados() {
        DocenteDTO docente = service.getDocenteConMasAsuntosPropiosDisfrutados();
        if (docente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(docente);
    }

    @PostMapping("/createDocente")
    public ResponseEntity<DocenteDTO> crearDocenteNuevo(@RequestBody DocenteDTO dto) {
        DocenteDTO docenteDTO = service.createDocente(dto);
        return ResponseEntity.accepted().body(docenteDTO);
    }
}
