package com.dzn50346.gestionDeDocentes.services;

import com.dzn50346.gestionDeDocentes.dto.AsignaturaDTO;
import com.dzn50346.gestionDeDocentes.models.Asignatura;
import com.dzn50346.gestionDeDocentes.models.Ciclo;
import com.dzn50346.gestionDeDocentes.models.Horario;
import com.dzn50346.gestionDeDocentes.repositories.AsignaturaRepository;
import com.dzn50346.gestionDeDocentes.repositories.CicloRepository;
import com.dzn50346.gestionDeDocentes.repositories.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaService {

    private final AsignaturaRepository repository;
    private CicloRepository cicloRepository;
    private HorarioRepository horarioRepository;

    @Autowired
    public AsignaturaService(AsignaturaRepository repository) {
        this.repository = repository;
    }

    public Asignatura getAsignaturaById(int id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Asignatura no encontrada con id: " + id));
    }

    public AsignaturaDTO crearAsignatura(AsignaturaDTO asignaturaDTO){
        if (repository.findById(asignaturaDTO.getIdDTO()).isPresent()){
            throw new IllegalArgumentException("Ya existe una asignatura con el id: " + asignaturaDTO.getIdDTO());
        }

        Ciclo ciclo = cicloRepository.findById(asignaturaDTO.getIdCicloDTO()).orElseThrow(() -> new RuntimeException("Ciclo no encontrado con id: " + asignaturaDTO.getIdCicloDTO()));
        Horario horario = horarioRepository.findById(asignaturaDTO.getIdHorarioDTO()).orElseThrow(() -> new RuntimeException("Horario no encontrado con el id: " + asignaturaDTO.getIdHorarioDTO()));

        Asignatura asignatura = new Asignatura();
        asignatura.setNombre(asignaturaDTO.getNombreDTO());
        asignatura.setCiclo(ciclo);
        asignatura.setCodigo(asignaturaDTO.getCodigoDTO());
        asignatura.setHorasSemanales(asignaturaDTO.getHorasSemanalesDTO());

        Asignatura asignaturaGuardada = repository.save(asignatura);

        return mapToDTO(asignaturaGuardada);
    }

    private AsignaturaDTO mapToDTO(Asignatura a){
        AsignaturaDTO dto = new AsignaturaDTO();

        dto.setIdDTO(a.getId());
        dto.setNombreDTO(a.getNombre());
        dto.setCodigoDTO(a.getCodigo());
        dto.setHorasSemanalesDTO(a.getHorasSemanales());

        if (a.getCiclo() != null){
            dto.setIdCicloDTO(a.getCiclo().getId());
        }

        return dto;
    }
}
