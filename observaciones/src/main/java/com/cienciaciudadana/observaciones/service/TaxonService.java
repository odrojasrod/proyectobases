package com.cienciaciudadana.observaciones.service;

import com.cienciaciudadana.observaciones.model.Taxon;
import com.cienciaciudadana.observaciones.repository.TaxonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaxonService {

    private final TaxonRepository taxonRepository;

    public TaxonService(TaxonRepository taxonRepository) {
        this.taxonRepository = taxonRepository;
    }

    public List<Taxon> findAll() {
        return taxonRepository.findAll();
    }

    public Optional<Taxon> findById(Long id) {
        return taxonRepository.findById(id);
    }

    public Taxon save(Taxon taxon) {
        return taxonRepository.save(taxon);
    }

    public void deleteById(Long id) {
        taxonRepository.deleteById(id);
    }
}