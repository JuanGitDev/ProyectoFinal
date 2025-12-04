package com.dzn50346.gestionDeDocentes.services;

import com.dzn50346.gestionDeDocentes.dto.AsuntoPropioDTO;
import com.dzn50346.gestionDeDocentes.models.AsuntoPropio;
import com.dzn50346.gestionDeDocentes.models.Docente;
import com.dzn50346.gestionDeDocentes.repositories.AsuntoPropioRepository;
import com.dzn50346.gestionDeDocentes.repositories.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class AsuntoPropioService {

    AsuntoPropioRepository repository;
    DocenteRepository docenteRepository;

    @Autowired
    public AsuntoPropioService(AsuntoPropioRepository repository) {
        this.repository = repository;
    }

    public AsuntoPropio getAsuntoPropioByID (int id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Asunto propio no encontrado con id: " + id));
    }

    public AsuntoPropioDTO solicitarDiaAsuntoPropio(AsuntoPropioDTO asuntoPropioDTO){
        AsuntoPropio asuntoPropio = new AsuntoPropio();

        Docente docente = docenteRepository.findById(asuntoPropioDTO.getIdDocenteDTO()).orElseThrow(()-> new RuntimeException("No se encuentra el docente especificado"));

        asuntoPropio.setDiaSolicitado(asuntoPropioDTO.getDiaSolicitadoDTO());
        asuntoPropio.setDescripcion(asuntoPropio.getDescripcion());
        asuntoPropio.setFechaTramitacion(null);
        asuntoPropio.setAprobado(false);
        asuntoPropio.setDocente(docente);

        return mapToDTO(asuntoPropio);
    }

    public AsuntoPropio validarAsuntoPropio(int id, boolean aprobado){
        AsuntoPropio asuntoPropio = repository.findById(id).orElseThrow(()-> new RuntimeException("Asunto propio no encontrado con id:" + id));
        LocalDate ahora = LocalDate.now();
        asuntoPropio.setAprobado(aprobado);
        asuntoPropio.setFechaTramitacion(ahora);

        return repository.save(asuntoPropio);
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
