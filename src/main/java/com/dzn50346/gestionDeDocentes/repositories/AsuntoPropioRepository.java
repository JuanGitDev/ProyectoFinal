package com.dzn50346.gestionDeDocentes.repositories;

import com.dzn50346.gestionDeDocentes.models.AsuntoPropio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AsuntoPropioRepository extends JpaRepository<AsuntoPropio, Integer> {

    public Optional<AsuntoPropio> findById(Integer id);
}
