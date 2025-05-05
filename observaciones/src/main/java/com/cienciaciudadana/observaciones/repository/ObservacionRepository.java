package com.cienciaciudadana.observaciones.repository;

import com.cienciaciudadana.observaciones.model.Observacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObservacionRepository extends JpaRepository<Observacion, Integer> {
}