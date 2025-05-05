package com.cienciaciudadana.observaciones.service;

import com.cienciaciudadana.observaciones.model.Observacion;
import com.cienciaciudadana.observaciones.repository.ObservacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
@Service
public class ObservacionService {

    @Autowired
    private ObservacionRepository observacionRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Observacion> findAll() {
        return observacionRepository.findAll();
    }

    public Optional<Observacion> findById(Integer id) {
        return observacionRepository.findById(id);
    }

    public Observacion save(Observacion observacion) {
        return observacionRepository.save(observacion);
    }

    public void deleteById(Integer id) {
        observacionRepository.deleteById(id);
    }

    public boolean existsById(Integer id) {
        return observacionRepository.existsById(id);
    }

    public void insertarObservacion(String correoUsuario, String nombreComun, String nombreCientifico,
                                    String urlImagen, String tipoTaxon, String calle, String ciudad,
                                    String estado, String pais, LocalDate fecha, Integer idLicencia) {
        String sql = "CALL insertar_observacion(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                correoUsuario,
                nombreComun,
                nombreCientifico,
                urlImagen,
                tipoTaxon,
                calle,
                ciudad,
                estado,
                pais,
                java.sql.Date.valueOf(fecha),
                idLicencia
        );
    }
}