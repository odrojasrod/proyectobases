package com.cienciaciudadana.observaciones.repository;
import com.cienciaciudadana.observaciones.model.Licencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenciaRepository extends JpaRepository<Licencia, Long> {
}