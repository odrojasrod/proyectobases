package com.cienciaciudadana.observaciones.controller;

import com.cienciaciudadana.observaciones.model.Direccion;
import com.cienciaciudadana.observaciones.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/direcciones")
public class DireccionController {

    @Autowired
    private DireccionService direccionService;

    @GetMapping("/todos")
    public List<Direccion> getAllDirecciones() {
        return direccionService.getAllDirecciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direccion> getDireccionById(@PathVariable Integer id) {
        Optional<Direccion> direccion = direccionService.getDireccionById(id);
        return direccion.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Direccion createDireccion(@RequestBody Direccion direccion) {
        return direccionService.saveDireccion(direccion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Direccion> updateDireccion(@PathVariable Integer id, @RequestBody Direccion direccionDetails) {
        Optional<Direccion> direccionOpt = direccionService.getDireccionById(id);
        if (!direccionOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Direccion direccion = direccionOpt.get();
        direccion.setCalle(direccionDetails.getCalle());
        direccion.setCiudad(direccionDetails.getCiudad());
        direccion.setEstado(direccionDetails.getEstado());
        direccion.setPais(direccionDetails.getPais());

        Direccion updatedDireccion = direccionService.saveDireccion(direccion);
        return ResponseEntity.ok(updatedDireccion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDireccion(@PathVariable Integer id) {
        Optional<Direccion> direccion = direccionService.getDireccionById(id);
        if (!direccion.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        direccionService.deleteDireccion(id);
        return ResponseEntity.noContent().build();
    }
}