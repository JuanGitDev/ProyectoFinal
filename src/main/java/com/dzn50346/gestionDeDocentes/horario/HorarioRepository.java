package com.dzn50346.gestionDeDocentes.horario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {

    Optional<Horario> findById(Integer id);
}
