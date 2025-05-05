package com.cienciaciudadana.observaciones.repository;

import com.cienciaciudadana.observaciones.model.Taxon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxonRepository extends JpaRepository<Taxon, Long> {

}