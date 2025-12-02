package com.dzn50346.gestionDeDocentes.services;

import com.dzn50346.gestionDeDocentes.dto.AsuntoPropioDTO;
import com.dzn50346.gestionDeDocentes.models.AsuntoPropio;
import com.dzn50346.gestionDeDocentes.repositories.AsuntoPropioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsuntoPropioService {

    AsuntoPropioRepository repository;

    @Autowired
    public AsuntoPropioService(AsuntoPropioRepository repository) {
        this.repository = repository;
    }

    public AsuntoPropio getAsuntoPropioByID (int id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No se encuentra el asunto propio especificado"));
    }

    public AsuntoPropioDTO solicitarDiaAsuntoPropio(AsuntoPropioDTO asuntoPropioDTO){

    }

    public AsuntoPropioDTO mapToDTO(AsuntoPropio asuntoPropio){
        AsuntoPropioDTO dto = new AsuntoPropioDTO();

        dto.setIdDTO(asuntoPropio.getId());
        dto.setDiaSolicitadoDTO(asuntoPropio.getDiaSolicitado());
        dto.setDescripcionDTO(asuntoPropio.getDescripcion());
        dto.setFechaTramitacionDTO(asuntoPropio.getFechaTramitacion());
        dto.setIdDocenteDTO(asuntoPropio.getDocente().getId());

        return dto;
    }
}
