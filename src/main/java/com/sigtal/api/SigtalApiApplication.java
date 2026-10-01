package com.sigtal.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la API SIGTAL.
 *
 * Evidencia:
 * GA7-220501096-AA5-EV01
 */
@SpringBootApplication
public class SigtalApiApplication {

    public static void main(String[] args) {

        // Inicia la aplicación Spring Boot.
        SpringApplication.run(SigtalApiApplication.class, args);
    }
}