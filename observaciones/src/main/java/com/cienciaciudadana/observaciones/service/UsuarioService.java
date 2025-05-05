package com.cienciaciudadana.observaciones.service;

import com.cienciaciudadana.observaciones.model.Direccion;
import com.cienciaciudadana.observaciones.model.Usuario;
import com.cienciaciudadana.observaciones.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioByCorreo(String correo) {
        return usuarioRepository.findById(correo);
    }
    @Transactional
    public void insertarUsuarioConDireccion(Usuario usuario, Direccion direccion) {
        String sql = "CALL insertar_usuarios(?, ?, ?, ?, ?, ?, ?)";

        try {
            jdbcTemplate.update(sql,
                    usuario.getNombre(),
                    usuario.getCorreo(),
                    usuario.getApellidos(),
                    direccion.getCalle(),
                    direccion.getEstado(),
                    direccion.getPais(),
                    direccion.getCiudad()
            );
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al insertar el usuario: " + e.getMessage());
        }
    }
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(String correo) {
        usuarioRepository.deleteById(correo);
    }
}