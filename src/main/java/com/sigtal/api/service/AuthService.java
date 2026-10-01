package com.sigtal.api.service;

import com.sigtal.api.model.Usuario;
import com.sigtal.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio encargado de gestionar el registro
 * y autenticación de usuarios.
 *
 * Evidencia:
 * GA7-220501096-AA5-EV01
 */
@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Registra un nuevo usuario en la base de datos.
     *
     * @param usuario datos del usuario
     * @return usuario registrado
     */
    public Usuario registrar(Usuario usuario) {

        // Verificamos que el nombre de usuario no exista.
        Usuario usuarioExistente =
                usuarioRepository.findByUsuario(usuario.getUsuario());

        if (usuarioExistente != null) {
            throw new RuntimeException(
                    "El usuario ya se encuentra registrado."
            );
        }

        // Si no se especifica un rol, se asigna uno por defecto.
        if (usuario.getRol() == null || usuario.getRol().isBlank()) {
            usuario.setRol("USUARIO");
        }

        // Si no se especifica el estado, se activa el usuario.
        if (usuario.getEstado() == null || usuario.getEstado().isBlank()) {
            usuario.setEstado("ACTIVO");
        }

        // Guardamos el usuario en la base de datos.
        return usuarioRepository.save(usuario);
    }

    /**
     * Realiza la autenticación de un usuario.
     *
     * @param usuario nombre de usuario
     * @param password contraseña
     * @return mensaje de autenticación
     */
    public String login(String usuario, String password) {

        // Buscamos el usuario en la base de datos.
        Usuario usuarioEncontrado =
                usuarioRepository.findByUsuario(usuario);

        // Verificamos si el usuario existe.
        if (usuarioEncontrado == null) {
            return "Error en la autenticación: usuario no encontrado.";
        }

        // Verificamos el estado del usuario.
        if (!"ACTIVO".equalsIgnoreCase(usuarioEncontrado.getEstado())) {
            return "Error en la autenticación: usuario inactivo.";
        }

        // Verificamos la contraseña.
        if (!usuarioEncontrado.getPassword().equals(password)) {
            return "Error en la autenticación: contraseña incorrecta.";
        }

        // Autenticación correcta.
        return "Autenticación satisfactoria.";
    }
}