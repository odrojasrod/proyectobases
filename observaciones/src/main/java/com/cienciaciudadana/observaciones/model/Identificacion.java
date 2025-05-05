package com.cienciaciudadana.observaciones.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Identificacion")
public class Identificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_identificacion")
    private Integer idIdentificacion;

    @Column(name = "correo_usuario")
    private String correoUsuario;

    @Column(name = "id_observacion")
    private Integer idObservacion;

    @Column(name = "calificacion")
    private Integer calificacion;

    // Getters and Setters

    public Integer getIdIdentificacion() {
        return idIdentificacion;
    }

    public void setIdIdentificacion(Integer idIdentificacion) {
        this.idIdentificacion = idIdentificacion;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public Integer getIdObservacion() {
        return idObservacion;
    }

    public void setIdObservacion(Integer idObservacion) {
        this.idObservacion = idObservacion;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }
}
