package com.dzn50346.gestionDeDocentes.controllers;

import com.dzn50346.gestionDeDocentes.dto.AsuntoPropioDTO;
import com.dzn50346.gestionDeDocentes.models.AsuntoPropio;
import com.dzn50346.gestionDeDocentes.services.AsuntoPropioService;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/gestionDocente/api/asuntosPropios")
public class AsuntoPropioController {

    AsuntoPropioService service;

    public AsuntoPropioController(AsuntoPropioService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<AsuntoPropioDTO> index(){
        return service.getAllAsuntoPropio();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AsuntoPropioDTO> show(@NonNull @PathVariable("id") int id) {
        AsuntoPropio asuntoPropio = service.getAsuntoPropioByID(id);
        return ResponseEntity.ok(service.mapToDTO(asuntoPropio));
    }

    @GetMapping(path = "/{id}/consultarDiasPropios")
    public List<AsuntoPropioDTO> mostrarDiasPropios(@NonNull @PathVariable("id") int id){
        return service.consultarDiasPropios(id);
    }

    @PostMapping(path = "")
    public ResponseEntity<AsuntoPropioDTO> create(@RequestBody AsuntoPropioDTO dto) {
        AsuntoPropioDTO asuntoPropioDTO = service.solicitarDiaAsuntoPropio(dto);
        return ResponseEntity.status(201).body(asuntoPropioDTO);
    }

    @PutMapping(path = "/{id}/validar")
    public ResponseEntity<AsuntoPropioDTO> update(@PathVariable("id") int id, @RequestBody AsuntoPropioDTO dto){
        AsuntoPropioDTO asuntoPropio = service.validarAsuntoPropio(id, dto.isAprobadoDTO());
        return ResponseEntity.accepted().body(asuntoPropio);
    }
}
