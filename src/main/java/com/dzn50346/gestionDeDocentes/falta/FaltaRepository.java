package com.dzn50346.gestionDeDocentes.falta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FaltaRepository extends JpaRepository<Falta, Integer> {
    Optional<Falta> findById(Integer id);
}
