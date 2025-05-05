package com.cienciaciudadana.observaciones.dto;

import java.time.LocalDate;
import java.util.List;

public class ObservationDetailDto {

    private Long observationId;
    private LocalDate fecha;

    private String correoUsuario;

    private String calle;
    private String ciudad;
    private String estado;
    private String pais;

    private String nombreCientifico;
    private String nombreComun;

    private List<String> taxonHierarchy;
    public ObservationDetailDto() {
    }

    // Constructor con todos los campos
    public ObservationDetailDto(Long observationId, LocalDate fecha, String correoUsuario,
                                String calle, String ciudad, String estado, String pais,
                                String nombreCientifico, String nombreComun,
                                List<String> taxonHierarchy) {
        this.observationId = observationId;
        this.fecha = fecha;
        this.correoUsuario = correoUsuario;
        this.calle = calle;
        this.ciudad = ciudad;
        this.estado = estado;
        this.pais = pais;
        this.nombreCientifico = nombreCientifico;
        this.nombreComun = nombreComun;
        this.taxonHierarchy = taxonHierarchy;
    }

    // Getters y setters

    public Long getObservationId() {
        return observationId;
    }

    public void setObservationId(Long observationId) {
        this.observationId = observationId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public List<String> getTaxonHierarchy() {
        return taxonHierarchy;
    }

    public void setTaxonHierarchy(List<String> taxonHierarchy) {
        this.taxonHierarchy = taxonHierarchy;
    }
}