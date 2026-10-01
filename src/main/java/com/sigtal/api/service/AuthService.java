package com.sigtal.api.service;

import com.sigtal.api.dto.UsuarioResponse;
import com.sigtal.api.model.Usuario;
import com.sigtal.api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // ==============================
    // REGISTRO DE USUARIO
    // ==============================
    public UsuarioResponse registrar(Usuario usuario) {

        // Verificar si el usuario ya existe
        if (usuarioRepository.existsByUsuario(usuario.getUsuario())) {
            throw new RuntimeException("El usuario ya existe.");
        }

        // Guardar usuario en MySQL
        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        // Devolver respuesta sin contraseña
        return convertirRespuesta(usuarioGuardado);
    }

    // ==============================
    // AUTENTICACIÓN
    // ==============================
    public String login(String usuario, String password) {

        Usuario usuarioEncontrado =
                usuarioRepository.findByUsuario(usuario);

        // Verificar si el usuario existe
        if (usuarioEncontrado == null) {
            throw new RuntimeException("Usuario no encontrado.");
        }

        // Verificar estado
        if (!"ACTIVO".equalsIgnoreCase(usuarioEncontrado.getEstado())) {
            throw new RuntimeException("El usuario está inactivo.");
        }

        // Verificar contraseña
        if (!usuarioEncontrado.getPassword().equals(password)) {
            throw new RuntimeException("Contraseña incorrecta.");
        }

        return "Autenticación satisfactoria.";
    }

    // ==============================
    // CONVERTIR ENTIDAD A RESPONSE
    // ==============================
    private UsuarioResponse convertirRespuesta(Usuario usuario) {

        return new UsuarioResponse(
                usuario.getIdUsuario(),
                usuario.getNombre(),
                usuario.getUsuario(),
                usuario.getRol(),
                usuario.getEstado()
        );
    }
}