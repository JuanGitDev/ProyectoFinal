package com.dzn50346.gestionDeDocentes.repositories;

import com.dzn50346.gestionDeDocentes.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findById(Integer id);
}
