package com.cienciaciudadana.observaciones.controller;

import com.cienciaciudadana.observaciones.model.Identificacion;
import com.cienciaciudadana.observaciones.service.IdentificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/identificaciones")
public class IdentificacionController {

    @Autowired
    private IdentificacionService identificacionService;

    @GetMapping
    public List<Identificacion> getAllIdentificaciones() {
        return identificacionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Identificacion> getIdentificacionById(@PathVariable Integer id) {
        return identificacionService.findById(id)
                .map(identificacion -> ResponseEntity.ok().body(identificacion))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Identificacion createIdentificacion(@RequestBody Identificacion identificacion) {
        return identificacionService.save(identificacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Identificacion> updateIdentificacion(@PathVariable Integer id, @RequestBody Identificacion updatedIdentificacion) {
        return identificacionService.findById(id)
                .map(identificacion -> {
                    identificacion.setCorreoUsuario(updatedIdentificacion.getCorreoUsuario());
                    identificacion.setIdObservacion(updatedIdentificacion.getIdObservacion());
                    identificacion.setCalificacion(updatedIdentificacion.getCalificacion());
                    Identificacion saved = identificacionService.save(identificacion);
                    return ResponseEntity.ok().body(saved);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIdentificacion(@PathVariable Integer id) {
        if (!identificacionService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        identificacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
