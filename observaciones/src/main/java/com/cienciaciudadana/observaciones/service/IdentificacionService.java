package com.cienciaciudadana.observaciones.service;

import com.cienciaciudadana.observaciones.model.Identificacion;
import com.cienciaciudadana.observaciones.repository.IdentificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IdentificacionService {

    @Autowired
    private IdentificacionRepository identificacionRepository;

    public List<Identificacion> findAll() {
        return identificacionRepository.findAll();
    }

    public Optional<Identificacion> findById(Integer id) {
        return identificacionRepository.findById(id);
    }

    public Identificacion save(Identificacion identificacion) {
        return identificacionRepository.save(identificacion);
    }

    public void deleteById(Integer id) {
        identificacionRepository.deleteById(id);
    }

    public boolean existsById(Integer id) {
        return identificacionRepository.existsById(id);
    }
}
