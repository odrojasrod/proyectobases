package com.cienciaciudadana.observaciones.controller;

import com.cienciaciudadana.observaciones.model.Taxon;
import com.cienciaciudadana.observaciones.service.TaxonService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taxon")
public class TaxonController {

    private final TaxonService taxonService;

    public TaxonController(TaxonService taxonService) {
        this.taxonService = taxonService;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Taxon>> getAllTaxons() {
        List<Taxon> taxons = taxonService.findAll();
        return ResponseEntity.ok(taxons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taxon> getTaxonById(@PathVariable Long id) {
        return taxonService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Taxon> createTaxon(@RequestBody Taxon taxon) {
        Taxon createdTaxon = taxonService.save(taxon);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTaxon);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Taxon> updateTaxon(@PathVariable Long id, @RequestBody Taxon taxon) {
        return taxonService.findById(id)
                .map(existingTaxon -> {
                    existingTaxon.setNombre(taxon.getNombre());
                    Taxon updated = taxonService.save(existingTaxon);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaxon(@PathVariable Long id) {
        try {
            taxonService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
