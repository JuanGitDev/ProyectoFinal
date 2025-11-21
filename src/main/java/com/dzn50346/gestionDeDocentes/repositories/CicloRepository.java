package com.dzn50346.gestionDeDocentes.repositories;

import com.dzn50346.gestionDeDocentes.models.Ciclo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CicloRepository extends JpaRepository<Ciclo, Integer> {
    Optional<Ciclo> findById(Integer id);
}
