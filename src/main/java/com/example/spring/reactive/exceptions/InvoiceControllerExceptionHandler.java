package com.example.spring.reactive.exceptions;


import com.example.spring.reactive.domain.ErrorDetails;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.dao.TransientDataAccessException;
import org.springframework.dao.TransientDataAccessResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.resource.NoResourceFoundException;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class InvoiceControllerExceptionHandler {

    @ExceptionHandler(NoResourceFoundException.class)
    public Mono<ResponseEntity<ErrorDetails>> handle404(NoResourceFoundException ex) {
        ErrorDetails error = new ErrorDetails("NOT_FOUND", ex.getMessage());
        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(error));
    }

    @ExceptionHandler(TransientDataAccessResourceException.class)
    public Mono<ResponseEntity<ErrorDetails>> serverException(TransientDataAccessResourceException ex) {
        ErrorDetails error = new ErrorDetails("INTERNAL_SERVER_ERROR", ex.getMessage());
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error));
    }
}
