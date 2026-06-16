package com.SaludUnificada.Esu.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ManejadorGlobalExcepciones extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoEncontradoExcepcion.class)
    public ResponseEntity<ErrorMessage> notFoundException(NoEncontradoExcepcion exception) {
        // Retorna un objeto ErrorMessage con el código de estado y el mensaje configurado en el servicio
        ErrorMessage message = new ErrorMessage(
                exception.getStatus(),
                LocalDateTime.now(),
                exception.getMessage(),
                exception.getMessage() // Usamos el mismo mensaje para la descripción por simplicidad
        );

        // Devuelve de forma controlada el código HTTP (ej: 404 NOT_FOUND) y el cuerpo JSON
        return ResponseEntity.status(exception.getStatus()).body(message);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        // Colección encargada de estructurar: campoConError -> mensajePersonalizado
        Map<String, Object> errors = new HashMap<>();

        // Recorre los fallos de restricciones en los atributos del DTO (ej: @NotBlank, @NotNull)
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        // Devuelve un código HTTP 400 BAD_REQUEST junto al mapa de campos inválidos
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
