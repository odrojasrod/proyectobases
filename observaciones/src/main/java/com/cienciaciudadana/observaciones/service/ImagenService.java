package com.cienciaciudadana.observaciones.service;

import com.cienciaciudadana.observaciones.model.Imagen;
import com.cienciaciudadana.observaciones.repository.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagenService {

    @Autowired
    private ImagenRepository imagenRepository;

    public List<Imagen> findAll() {
        return imagenRepository.findAll();
    }

    public Optional<Imagen> findById(Integer id) {
        return imagenRepository.findById(Long.valueOf(id));
    }

    public Imagen save(Imagen imagen) {
        return imagenRepository.save(imagen);
    }

    public void deleteById(Integer id) {
        imagenRepository.deleteById(Long.valueOf(id));
    }

    public boolean existsById(Integer id) {
        return imagenRepository.existsById(Long.valueOf(id));
    }
}