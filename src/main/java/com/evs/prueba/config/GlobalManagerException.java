package com.evs.prueba.config;

import jakarta.persistence.NoResultException;
import org.apache.coyote.BadRequestException;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(annotations = RestController.class, basePackages = "com.evs.prueba.controller")
public class GlobalManagerException  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> solicitudErronea(BadRequestException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La solicitud tiene errores");
    }

    @ExceptionHandler(NoResultException.class)
    public ResponseEntity<String> noEncontradoException(NoResultException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Recurso no encontrado");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> sqlError(Exception ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrio un error");
    }
}
