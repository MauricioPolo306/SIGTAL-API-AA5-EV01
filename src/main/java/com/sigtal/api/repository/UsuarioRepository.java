package com.sigtal.api.repository;

import com.sigtal.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar los usuarios
 * de la base de datos SIGTAL.
 *
 * Evidencia:
 * GA7-220501096-AA5-EV01
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param usuario nombre de usuario
     * @return usuario encontrado
     */
    Usuario findByUsuario(String usuario);
}