package com.dzn50346.gestionDeDocentes.services;

import com.dzn50346.gestionDeDocentes.dto.AsuntoPropioDTO;
import com.dzn50346.gestionDeDocentes.models.AsuntoPropio;
import com.dzn50346.gestionDeDocentes.models.Docente;
import com.dzn50346.gestionDeDocentes.repositories.AsuntoPropioRepository;
import com.dzn50346.gestionDeDocentes.repositories.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsuntoPropioService {

    AsuntoPropioRepository repository;
    DocenteRepository docenteRepository;

    @Autowired
    public AsuntoPropioService(AsuntoPropioRepository repository, DocenteRepository docenteRepository) {
        this.repository = repository;
        this.docenteRepository = docenteRepository;
    }

    public AsuntoPropio getAsuntoPropioByID(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Asunto propio no encontrado con id: " + id));
    }

    public List<AsuntoPropioDTO> getAllAsuntoPropio() {
        return repository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<AsuntoPropioDTO> consultarDiasPropios(int idDocente){
        Docente docente = docenteRepository.findById(idDocente).orElseThrow(()-> new RuntimeException("No se ha encontrado el docente con el id: " + idDocente));
        return repository.findByDocente(docente).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public AsuntoPropioDTO solicitarDiaAsuntoPropio(AsuntoPropioDTO asuntoPropioDTO) {
        Docente docente = docenteRepository.findById(asuntoPropioDTO.getIdDocenteDTO())
                .orElseThrow(() -> new RuntimeException("No se encuentra el docente especificado"));

        if (asuntoPropioDTO.getDiaSolicitadoDTO().before(new Date())) {
            throw new RuntimeException("La fecha solicitada no puede ser en el pasado.");
        }

        List<AsuntoPropio> asuntosAprobados = repository.findByDocenteAndAprobado(docente, true);
        int trimestreSolicitado = getTrimestre(asuntoPropioDTO.getDiaSolicitadoDTO());

        boolean yaTieneEnTrimestre = asuntosAprobados.stream()
                .anyMatch(asunto -> getTrimestre(asunto.getDiaSolicitado()) == trimestreSolicitado);

        if (yaTieneEnTrimestre) {
            throw new RuntimeException("El docente ya ha disfrutado de un día de asuntos propios en este trimestre.");
        }


        AsuntoPropio newAsuntoPropio = new AsuntoPropio();
        newAsuntoPropio.setDiaSolicitado(asuntoPropioDTO.getDiaSolicitadoDTO());
        newAsuntoPropio.setDescripcion(asuntoPropioDTO.getDescripcionDTO());
        newAsuntoPropio.setAprobado(false);
        newAsuntoPropio.setDocente(docente);
        newAsuntoPropio.setFechaTramitacion(null);

        AsuntoPropio savedAsuntoPropio = repository.save(newAsuntoPropio);
        return mapToDTO(savedAsuntoPropio);
    }

    public AsuntoPropioDTO validarAsuntoPropio(int id, boolean aprobado) {
        AsuntoPropio asuntoPropio = getAsuntoPropioByID(id);
        asuntoPropio.setAprobado(aprobado);
        asuntoPropio.setFechaTramitacion(LocalDate.now());

        AsuntoPropio updatedAsuntoPropio = repository.save(asuntoPropio);
        return mapToDTO(updatedAsuntoPropio);
    }

    public List<AsuntoPropioDTO> getAsuntosPropiosPendientesDeDisfrutar() {
        return repository.findByAprobadoAndDiaSolicitadoAfter(true, new Date()).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public AsuntoPropioDTO mapToDTO(AsuntoPropio asuntoPropio) {
        AsuntoPropioDTO dto = new AsuntoPropioDTO();
        dto.setIdDTO(asuntoPropio.getId());
        dto.setDiaSolicitadoDTO(asuntoPropio.getDiaSolicitado());
        dto.setDescripcionDTO(asuntoPropio.getDescripcion());
        dto.setFechaTramitacionDTO(asuntoPropio.getFechaTramitacion());
        dto.setAprobadoDTO(asuntoPropio.isAprobado());
        dto.setIdDocenteDTO(asuntoPropio.getDocente().getId());
        return dto;
    }

    private int getTrimestre(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return (localDate.getMonthValue() - 1) / 3 + 1;
    }
}
