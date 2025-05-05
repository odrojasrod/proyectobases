package com.cienciaciudadana.observaciones.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Observacion")
public class Observacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_observacion")
    private Integer idObservacion;

    @Column(name = "nombre_comun")
    private String nombreComun;

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Column(name = "id_imagen")
    private Integer idImagen;

    @Column(name = "id_taxon")
    private Integer idTaxon;

    @Column(name = "id_direccion")
    private Integer idDireccion;

    // Getters and Setters

    public Integer getIdObservacion() {
        return idObservacion;
    }

    public void setIdObservacion(Integer idObservacion) {
        this.idObservacion = idObservacion;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public Integer getIdTaxon() {
        return idTaxon;
    }

    public void setIdTaxon(Integer idTaxon) {
        this.idTaxon = idTaxon;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }
}