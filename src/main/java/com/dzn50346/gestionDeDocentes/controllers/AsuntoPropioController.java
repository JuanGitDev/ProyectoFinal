package com.dzn50346.gestionDeDocentes.controllers;

import com.dzn50346.gestionDeDocentes.dto.AsuntoPropioDTO;
import com.dzn50346.gestionDeDocentes.models.AsuntoPropio;
import com.dzn50346.gestionDeDocentes.services.AsuntoPropioService;
import lombok.NonNull;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "{api-endpoint}/asuntosPropios")
public class AsuntoPropioController {

    AsuntoPropioService service;

    public AsuntoPropioController(AsuntoPropioService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<AsuntoPropio> index(){
        return service.getAllAsuntoPropio();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AsuntoPropio> show(@NonNull @PathVariable("id") int id)throws Exception{
        AsuntoPropio asuntoPropio = service.getAsuntoPropioByID(id);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(asuntoPropio);
    }

    @PutMapping(path = "/{id}/validar")
    public ResponseEntity<AsuntoPropio> update(@PathVariable("id") int id, @RequestBody AsuntoPropioDTO dto){
        AsuntoPropio asuntoPropio = service.validarAsuntoPropio(dto, id);
        return ResponseEntity.accepted().body(asuntoPropio);
    }

}
