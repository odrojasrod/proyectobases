package com.cienciaciudadana.observaciones.controller;

import com.cienciaciudadana.observaciones.model.Observacion;
import com.cienciaciudadana.observaciones.service.ObservacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
@RestController
@RequestMapping("/api/observaciones")
public class ObservacionController {

    @Autowired
    private ObservacionService observacionService;

    @GetMapping("/todos")
    public List<Observacion> getAllObservaciones() {
        return observacionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Observacion> getObservacionById(@PathVariable Integer id) {
        return observacionService.findById(id)
                .map(observacion -> ResponseEntity.ok().body(observacion))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/insertar")
    public ResponseEntity<String> insertarObservacion(@RequestParam String correoUsuario,
                                                      @RequestParam String nombreComun,
                                                      @RequestParam String nombreCientifico,
                                                      @RequestParam String urlImagen,
                                                      @RequestParam String tipoTaxon,
                                                      @RequestParam String calle,
                                                      @RequestParam String ciudad,
                                                      @RequestParam String estado,
                                                      @RequestParam String pais,
                                                      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha,
                                                      @RequestParam Integer idLicencia) {
        observacionService.insertarObservacion(correoUsuario, nombreComun, nombreCientifico,
                urlImagen, tipoTaxon, calle, ciudad, estado, pais, fecha, idLicencia);
        return ResponseEntity.ok("Observación insertada correctamente con licencia.");
    }

    @PostMapping
    public Observacion createObservacion(@RequestBody Observacion observacion) {
        return observacionService.save(observacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Observacion> updateObservacion(@PathVariable Integer id, @RequestBody Observacion updatedObservacion) {
        return observacionService.findById(id)
                .map(observacion -> {
                    observacion.setNombreComun(updatedObservacion.getNombreComun());
                    observacion.setNombreCliente(updatedObservacion.getNombreCliente());
                    observacion.setIdImagen(updatedObservacion.getIdImagen());
                    observacion.setIdTaxon(updatedObservacion.getIdTaxon());
                    observacion.setIdDireccion(updatedObservacion.getIdDireccion());
                    Observacion saved = observacionService.save(observacion);
                    return ResponseEntity.ok().body(saved);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteObservacion(@PathVariable Integer id) {
        if (!observacionService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        observacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}