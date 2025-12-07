package com.dzn50346.gestionDeDocentes.services;

import com.dzn50346.gestionDeDocentes.dto.DocenteDTO;
import com.dzn50346.gestionDeDocentes.models.Docente;
import com.dzn50346.gestionDeDocentes.repositories.DocenteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class DocenteService {

    DocenteRepository repository;

    public DocenteService(DocenteRepository repository) {
        this.repository = repository;
    }

    public List<DocenteDTO> mostrarDocentes(){
        return repository.findAll().stream()
                .map(this::mapToDTO)
                .toList();
    }

    public List<DocenteDTO> getDocentesOrdenadosPorApellidos() {
        List<Docente> docentes = repository.findAllByOrderByApellidosAsc();
        return docentes.stream()
                .map(this::mapToDTO)
                .toList();
    }

    public DocenteDTO createDocente(DocenteDTO docenteDTO){
        try {
            Docente docente = new Docente();
            docente.setNombre(docenteDTO.getNombreDTO());
            docente.setAntiguedad(docenteDTO.getAntiguedadDTO());
            docente.setApellidos(docenteDTO.getApellidosDTO());
            docente.setEmail(docente.getEmail());
            docente.setSiglas(docenteDTO.getSiglasDTO());
            docente.setTipo(docenteDTO.getTipoDTO());

            Docente docenteGuardado = repository.save(docente);
            return mapToDTO(docenteGuardado);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }


    private DocenteDTO mapToDTO(Docente docente) {
        DocenteDTO dto = new DocenteDTO();
        dto.setIdDTO(docente.getId());
        dto.setNombreDTO(docente.getNombre());
        dto.setApellidosDTO(docente.getApellidos());
        dto.setEmailDTO(docente.getEmail());
        dto.setSiglasDTO(docente.getSiglas());
        dto.setTipoDTO(docente.getTipo());

        return dto;
    }
}
