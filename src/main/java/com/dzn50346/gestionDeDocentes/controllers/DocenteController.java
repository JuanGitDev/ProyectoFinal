package com.dzn50346.gestionDeDocentes.controllers;

import com.dzn50346.gestionDeDocentes.dto.DocenteDTO;
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
    public List<DocenteDTO> mostrarDocentes () throws Exception{
        return service.mostrarDocentes();
    }

    @GetMapping(path = "/getDocentesOrdenadosPorApellidos")
    public List<DocenteDTO> mostrarDocentesOrdenadoPorApellidos() throws Exception{
        return service.getDocentesOrdenadosPorApellidos();
    }

    @PostMapping("/createDocente")
    public ResponseEntity<DocenteDTO> crearDocenteNuevo(@RequestBody DocenteDTO dto)throws Exception{
        DocenteDTO docenteDTO = service.createDocente(dto);
        return ResponseEntity.accepted().body(docenteDTO);
    }
}
