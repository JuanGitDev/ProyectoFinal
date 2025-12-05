package com.dzn50346.gestionDeDocentes.services;

import com.dzn50346.gestionDeDocentes.dto.AsuntoPropioDTO;
import com.dzn50346.gestionDeDocentes.models.AsuntoPropio;
import com.dzn50346.gestionDeDocentes.models.Docente;
import com.dzn50346.gestionDeDocentes.repositories.AsuntoPropioRepository;
import com.dzn50346.gestionDeDocentes.repositories.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class AsuntoPropioService {

    AsuntoPropioRepository repository;
    DocenteRepository docenteRepository;

    @Autowired
    public AsuntoPropioService(AsuntoPropioRepository repository, DocenteRepository docenteRepository) {
        this.repository = repository;
        this.docenteRepository = docenteRepository;
    }

    public AsuntoPropio getAsuntoPropioByID (int id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Asunto propio no encontrado con id: " + id));
    }

    public List<AsuntoPropio> getAllAsuntoPropio(){
        return repository.findAll();
    }

    public AsuntoPropio solicitarDiaAsuntoPropio(AsuntoPropioDTO asuntoPropioDTO) throws Exception{
        Docente docente = docenteRepository.findById(asuntoPropioDTO.getIdDocenteDTO()).orElseThrow(()-> new RuntimeException("No se encuentra el docente especificado"));

        try {
            AsuntoPropio newAsuntoPropio = AsuntoPropio.builder()
                    .diaSolicitado(asuntoPropioDTO.getDiaSolicitadoDTO())
                    .descripcion(asuntoPropioDTO.getDescripcionDTO())
                    .aprobado(false)
                    .docente(docente)
                    .fechaTramitacion(null)
                    .build();

            repository.save(newAsuntoPropio);

            int asuntoPropioTableQuantity = (int) repository.findAll().size();
            return repository.findById(asuntoPropioTableQuantity).orElseThrow(()-> new RuntimeException("Asunto propio no encontrado"));
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar " + e);
        }
    }

    public AsuntoPropio validarAsuntoPropio(AsuntoPropioDTO dto, int id){
        AsuntoPropio asuntoPropio = repository.findById(id).orElseThrow(()-> new RuntimeException("Asunto propio no encontrado con id: " + id));
        LocalDate ahora = LocalDate.now();

        asuntoPropio.setAprobado(dto.isAprobadoDTO());
        asuntoPropio.setFechaTramitacion(ahora);

        return repository.save(asuntoPropio);
    }
}
