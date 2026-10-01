package com.sigtal.api.controller;

import com.sigtal.api.model.Usuario;
import com.sigtal.api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * Controlador REST encargado de gestionar
 * el registro y autenticación de usuarios.
 *
 * Evidencia:
 * GA7-220501096-AA5-EV01
 */
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * Endpoint para registrar un usuario.
     *
     * Método HTTP: POST
     * URL: /api/auth/registro
     *
     * @param usuario información del usuario
     * @return usuario registrado
     */
    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@RequestBody Usuario usuario) {

        try {

            Usuario usuarioRegistrado =
                    authService.registrar(usuario);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(usuarioRegistrado);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    /**
     * Endpoint para iniciar sesión.
     *
     * Método HTTP: POST
     * URL: /api/auth/login
     *
     * @param usuario objeto que contiene usuario y contraseña
     * @return resultado de la autenticación
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody Usuario usuario) {

        String resultado = authService.login(
                usuario.getUsuario(),
                usuario.getPassword()
        );

        if (resultado.equals("Autenticación satisfactoria.")) {

            return ResponseEntity.ok(resultado);

        }

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(resultado);
    }
}