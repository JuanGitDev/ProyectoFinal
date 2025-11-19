package com.dzn50346.gestionDeDocentes.departamento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {

    Optional<Departamento> findById(Integer id);
}
