package com.dzn50346.gestionDeDocentes.services;

import com.dzn50346.gestionDeDocentes.dto.AsignaturaDTO;
import com.dzn50346.gestionDeDocentes.models.Asignatura;
import com.dzn50346.gestionDeDocentes.models.Ciclo;
import com.dzn50346.gestionDeDocentes.repositories.AsignaturaRepository;
import com.dzn50346.gestionDeDocentes.repositories.CicloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AsignaturaService {

    private final AsignaturaRepository repository;
    private final CicloRepository cicloRepository;

    @Autowired
    public AsignaturaService(AsignaturaRepository repository, CicloRepository cicloRepository) {
        this.repository = repository;
        this.cicloRepository = cicloRepository;
    }

    public Asignatura getAsignaturaById(int id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Asignatura no encontrada con id: " + id));
    }

    @Transactional
    public AsignaturaDTO crearAsignatura(AsignaturaDTO asignaturaDTO){
        // 1. Comprobar si ya existe una asignatura con el mismo código
        if (repository.findByCodigo(asignaturaDTO.getCodigoDTO()).isPresent()){
            throw new IllegalArgumentException("Ya existe una asignatura con el código: " + asignaturaDTO.getCodigoDTO());
        }

        // 2. Buscar el ciclo asociado
        Ciclo ciclo = cicloRepository.findById(asignaturaDTO.getIdCicloDTO()).orElseThrow(() -> new RuntimeException("Ciclo no encontrado con id: " + asignaturaDTO.getIdCicloDTO()));

        // 3. Crear la entidad Asignatura a partir del DTO
        Asignatura asignatura = new Asignatura();
        asignatura.setNombre(asignaturaDTO.getNombreDTO());
        asignatura.setCiclo(ciclo);
        asignatura.setCodigo(asignaturaDTO.getCodigoDTO());
        asignatura.setHorasSemanales(asignaturaDTO.getHorasSemanalesDTO());
        // El campo 'horarios' se deja vacío, como hemos acordado

        // 4. Guardar la nueva asignatura en la base de datos
        Asignatura asignaturaGuardada = repository.save(asignatura);

        // 5. Mapear la entidad guardada a un DTO para la respuesta
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
