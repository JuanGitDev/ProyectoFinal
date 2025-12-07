package com.dzn50346.gestionDeDocentes.repositories;

import com.dzn50346.gestionDeDocentes.models.AsuntoPropio;
import com.dzn50346.gestionDeDocentes.models.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AsuntoPropioRepository extends JpaRepository<AsuntoPropio, Integer> {

    public Optional<AsuntoPropio> findById(Integer id);

    public List<AsuntoPropio> findByDocente(Docente idDocente);
}
