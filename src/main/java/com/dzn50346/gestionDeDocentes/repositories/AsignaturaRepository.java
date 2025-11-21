package com.dzn50346.gestionDeDocentes.repositories;

import com.dzn50346.gestionDeDocentes.models.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> {

    Optional<Asignatura> findById(Integer id);
}
