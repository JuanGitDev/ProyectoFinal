package com.dzn50346.gestionDeDocentes.services;

import com.dzn50346.gestionDeDocentes.dto.AsignaturaDTO;
import com.dzn50346.gestionDeDocentes.models.Asignatura;
import com.dzn50346.gestionDeDocentes.repositories.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaService {

    private final AsignaturaRepository repository;

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

        Asignatura asignatura = new Asignatura();
        asignatura.setNombre(asignaturaDTO.getNombreDTO());
        asignatura.setCiclo();
    }
}
