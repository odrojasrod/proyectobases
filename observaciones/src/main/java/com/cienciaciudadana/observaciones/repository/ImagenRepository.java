package com.cienciaciudadana.observaciones.repository;

import com.cienciaciudadana.observaciones.model.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Long> {

}