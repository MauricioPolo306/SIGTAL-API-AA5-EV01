package com.sigtal.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 * Entidad que representa la tabla usuarios
 * de la base de datos SIGTAL.
 *
 * Evidencia:
 * GA7-220501096-AA5-EV01
 */
@Entity
@Table(name = "usuarios")
public class Usuario {

    // Llave primaria de la tabla usuarios.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    // Nombre completo del usuario.
    @Column(name = "nombre")
    private String nombre;

    // Nombre utilizado para iniciar sesión.
    @Column(name = "usuario", nullable = false, unique = true)
    private String usuario;

    // Contraseña del usuario.
    @Column(name = "password", nullable = false)
    private String password;

    // Rol asignado al usuario.
    @Column(name = "rol")
    private String rol;

    // Estado actual del usuario.
    @Column(name = "estado", nullable = false)
    private String estado;

    // Fecha en la que se registró el usuario.
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    // Constructor vacío requerido por JPA.
    public Usuario() {
    }

    // Getters y Setters.

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}