package com.dzn50346.gestionDeDocentes.asuntoPropio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AsuntoPropioRepository extends JpaRepository<AsuntoPropio, Integer> {

    public Optional<AsuntoPropio> findById(Integer id);
}
