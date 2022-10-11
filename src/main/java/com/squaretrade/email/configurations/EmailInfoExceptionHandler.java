package com.squaretrade.email.configurations;

import com.squaretrade.email.dto.EmailInfoError;
import jakarta.persistence.EntityExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@ControllerAdvice
@RestController
public class EmailInfoExceptionHandler {

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<EmailInfoError> emailAlreadyExistsException(Exception ex) {
        EmailInfoError emailInfoError = EmailInfoError.builder()
                .time(Instant.now())
                .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .message("Email info already exist!")
                .build();
        return new ResponseEntity<>(emailInfoError, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<EmailInfoError> wrongEmailException(Exception ex) {
        EmailInfoError emailInfoError = EmailInfoError.builder()
                .time(Instant.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Email with bad format. Please check.")
                .build();
        return new ResponseEntity<>(emailInfoError, HttpStatus.BAD_REQUEST);
    }

}
