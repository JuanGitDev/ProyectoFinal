package com.dzn50346.gestionDeDocentes.docente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocenteRepository extends JpaRepository<Docente, Integer> {

    Optional<Docente> findById(Integer id);
}
