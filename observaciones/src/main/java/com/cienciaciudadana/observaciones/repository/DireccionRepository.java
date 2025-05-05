package com.cienciaciudadana.observaciones.repository;
import com.cienciaciudadana.observaciones.model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Integer> {
}