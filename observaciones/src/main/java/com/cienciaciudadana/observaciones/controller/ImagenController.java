package com.cienciaciudadana.observaciones.controller;

import com.cienciaciudadana.observaciones.model.Imagen;
import com.cienciaciudadana.observaciones.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imagenes")
public class ImagenController {

    @Autowired
    private ImagenService imagenService;

    @GetMapping("/todos")
    public List<Imagen> getAllImagenes() {
        return imagenService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imagen> getImagenById(@PathVariable Integer id) {
        return imagenService.findById(id)
                .map(imagen -> ResponseEntity.ok().body(imagen))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Imagen createImagen(@RequestBody Imagen imagen) {
        return imagenService.save(imagen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imagen> updateImagen(@PathVariable Integer id, @RequestBody Imagen updatedImagen) {
        return imagenService.findById(id)
                .map(imagen -> {
                    imagen.setCorreoUsuario(updatedImagen.getCorreoUsuario());
                    imagen.setFecha(updatedImagen.getFecha());
                    imagen.setUrl(updatedImagen.getUrl());
                    imagen.setIdLicencia(updatedImagen.getIdLicencia());
                    Imagen saved = imagenService.save(imagen);
                    return ResponseEntity.ok().body(saved);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImagen(@PathVariable Integer id) {
        if (!imagenService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        imagenService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}