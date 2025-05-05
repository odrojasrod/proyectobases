package com.cienciaciudadana.observaciones.repository;

import com.cienciaciudadana.observaciones.model.Identificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentificacionRepository extends JpaRepository<Identificacion, Integer> {
}
