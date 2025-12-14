package com.dzn50346.gestionDeDocentes.repositories;

import com.dzn50346.gestionDeDocentes.models.AsuntoPropio;
import com.dzn50346.gestionDeDocentes.models.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AsuntoPropioRepository extends JpaRepository<AsuntoPropio, Integer> {

    public Optional<AsuntoPropio> findById(Integer id);

    public List<AsuntoPropio> findByDocente(Docente idDocente);

    public List<AsuntoPropio> findByDocenteAndAprobado(Docente docente, boolean aprobado);

    List<AsuntoPropio> findByAprobadoAndDiaSolicitadoAfter(boolean aprobado, Date fecha);

    @Query("SELECT ap.docente FROM AsuntoPropio ap WHERE ap.aprobado = true AND ap.diaSolicitado < CURRENT_DATE GROUP BY ap.docente ORDER BY count(ap) DESC")
    List<Docente> findDocenteWithMostAsuntosPropiosDisfrutados();
}
