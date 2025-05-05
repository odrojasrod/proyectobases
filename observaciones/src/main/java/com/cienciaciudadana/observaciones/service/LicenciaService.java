package com.cienciaciudadana.observaciones.service;
import com.cienciaciudadana.observaciones.model.Licencia;
import com.cienciaciudadana.observaciones.repository.LicenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicenciaService {

    @Autowired
    private LicenciaRepository licenciaRepository;

    public List<Licencia> getAllLicencias() {
        return licenciaRepository.findAll();
    }

    public Optional<Licencia> getLicenciaById(Long id) {
        return licenciaRepository.findById(id);
    }

    public Licencia saveLicencia(Licencia licencia) {
        return licenciaRepository.save(licencia);
    }

    public void deleteLicencia(Long id) {
        licenciaRepository.deleteById(id);
    }
}