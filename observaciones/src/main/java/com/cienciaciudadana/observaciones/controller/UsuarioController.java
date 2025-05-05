package com.cienciaciudadana.observaciones.controller;

import com.cienciaciudadana.observaciones.model.Direccion;
import com.cienciaciudadana.observaciones.model.Usuario;
import com.cienciaciudadana.observaciones.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/todos")
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{correo}")
    public ResponseEntity<Usuario> getUsuarioByCorreo(@PathVariable String correo) {
        Optional<Usuario> usuario = usuarioService.getUsuarioByCorreo(correo);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/insertar-con-direccion")
    public ResponseEntity<Void> insertarUsuarioConDireccion(@RequestBody UsuarioRequest request) {
        try {
            Usuario usuario = new Usuario();
            usuario.setCorreo(request.getCorreo());
            usuario.setNombre(request.getNombre());
            usuario.setApellidos(request.getApellidos());

            Direccion direccion = new Direccion();
            direccion.setCalle(request.getCalle());
            direccion.setCiudad(request.getCiudad());
            direccion.setEstado(request.getEstado());
            direccion.setPais(request.getPais());

            usuarioService.insertarUsuarioConDireccion(usuario, direccion);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    // Request DTO para insertar usuario con dirección
    public static class UsuarioRequest {
        private String correo;
        private String nombre;
        private String apellidos;

        private String calle;
        private String ciudad;
        private String estado;
        private String pais;

        // Getters y setters

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
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
    }
}