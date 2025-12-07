package com.dzn50346.gestionDeDocentes.controllers;

import com.dzn50346.gestionDeDocentes.dto.AsignaturaDTO;
import com.dzn50346.gestionDeDocentes.dto.AsuntoPropioDTO;
import com.dzn50346.gestionDeDocentes.models.Asignatura;
import com.dzn50346.gestionDeDocentes.services.AsignaturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/gestionDocente/api/asignaturas")
public class AsignaturaController {

    private final AsignaturaService service;

    public AsignaturaController(AsignaturaService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<AsignaturaDTO> getAllAsignatura(){
        return service.getAllAsignaturas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignaturaDTO> getAsignaturaById(@PathVariable("id") int id) throws Exception{
        Asignatura asignatura = service.getAsignaturaById(id);
        return ResponseEntity.ok(service.mapToDTO(asignatura));
    }

    @PostMapping("")
    public ResponseEntity<AsignaturaDTO> postAsignatura(@RequestBody AsignaturaDTO dto) throws Exception{
        AsignaturaDTO asignaturaDTO = service.crearAsignatura(dto);
        return ResponseEntity.accepted().body(asignaturaDTO);
    }

}
