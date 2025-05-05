package com.cienciaciudadana.observaciones.controller;

import com.cienciaciudadana.observaciones.model.Licencia;
import com.cienciaciudadana.observaciones.service.LicenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/licencias")
public class LicenciaController {

    @Autowired
    private LicenciaService licenciaService;

    @GetMapping("/todos")
    public List<Licencia> getAllLicencias() {
        return licenciaService.getAllLicencias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Licencia> getLicenciaById(@PathVariable Long id) {
        Optional<Licencia> licencia = licenciaService.getLicenciaById(id);
        return licencia.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Licencia createLicencia(@RequestBody Licencia licencia) {
        return licenciaService.saveLicencia(licencia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Licencia> updateLicencia(@PathVariable Long id, @RequestBody Licencia licenciaDetails) {
        Optional<Licencia> licenciaOpt = licenciaService.getLicenciaById(id);
        if (!licenciaOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Licencia licencia = licenciaOpt.get();
        licencia.setNombre(licenciaDetails.getNombre());
        Licencia updatedLicencia = licenciaService.saveLicencia(licencia);
        return ResponseEntity.ok(updatedLicencia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLicencia(@PathVariable Long id) {
        Optional<Licencia> licencia = licenciaService.getLicenciaById(id);
        if (!licencia.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        licenciaService.deleteLicencia(id);
        return ResponseEntity.noContent().build();
    }
}