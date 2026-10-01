package com.sigtal.api.controller;

import com.sigtal.api.dto.UsuarioResponse;
import com.sigtal.api.model.Usuario;
import com.sigtal.api.service.AuthService;
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

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * Endpoint para registrar un usuario.
     *
     * POST /api/auth/registro
     */
    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@RequestBody Usuario usuario) {

        try {

            UsuarioResponse usuarioRegistrado =
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
     * POST /api/auth/login
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody Usuario usuario) {

        try {

            String resultado = authService.login(
                    usuario.getUsuario(),
                    usuario.getPassword()
            );

            return ResponseEntity.ok(resultado);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());
        }
    }
}