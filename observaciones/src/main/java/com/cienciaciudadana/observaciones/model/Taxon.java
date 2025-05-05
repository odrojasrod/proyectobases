package com.cienciaciudadana.observaciones.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Taxon")
public class Taxon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTaxon;

    private String nombre;

    public Taxon() {
    }

    public Taxon(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdTaxon() {
        return idTaxon;
    }

    public void setIdTaxon(Long idTaxon) {
        this.idTaxon = idTaxon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}