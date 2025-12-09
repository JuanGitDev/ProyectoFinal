package com.dzn50346.gestionDeDocentes.services;

import com.dzn50346.gestionDeDocentes.dto.DocenteDTO;
import com.dzn50346.gestionDeDocentes.dto.DocenteDepartamentoDTO;
import com.dzn50346.gestionDeDocentes.models.Departamento;
import com.dzn50346.gestionDeDocentes.models.Docente;
import com.dzn50346.gestionDeDocentes.repositories.DepartamentoRepository;
import com.dzn50346.gestionDeDocentes.repositories.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteService {

    private final DocenteRepository repository;
    private final DepartamentoRepository departamentoRepository;

    @Autowired
    public DocenteService(DocenteRepository repository, DepartamentoRepository departamentoRepository) {
        this.repository = repository;
        this.departamentoRepository = departamentoRepository;
    }

    public List<DocenteDTO> mostrarDocentes(){
        return repository.findAll().stream()
                .map(this::mapToDTO)
                .toList();
    }

    public List<DocenteDepartamentoDTO> mostrarDocentesConDepto(){
        return repository.findAll().stream()
                .map(this::mapToDocenteDeptoDTO)
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

    private DocenteDepartamentoDTO mapToDocenteDeptoDTO(Docente docente){
        DocenteDepartamentoDTO dto = new DocenteDepartamentoDTO();
        dto.setNombreDocente(docente.getNombre());
        dto.setApellidoDocente(docente.getApellidos());

        Departamento departamento = docente.getDepartamento();
        if (departamento != null) {
            dto.setDepartamento(departamento.getNombre());
            dto.setCodigoDepartamento(departamento.getCodigo());
        } else {
            // Opcional: manejar el caso de que no haya departamento
            dto.setDepartamento("Sin departamento");
            dto.setCodigoDepartamento("N/A");
        }
        return dto;
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
