package it.epicode.capstone.exceptions;

import it.epicode.capstone.models.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> UserNotFoundException (UserNotFoundException e) {
        Error error = new Error();
        error.setMessage(e.getMessage());
        error.setErrorStatus(HttpStatus.NOT_FOUND);
        error.setErrorTime(LocalDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<Object> UnauthorizedException (UnauthorizedException e) {
        Error error = new Error();
        error.setMessage(e.getMessage());
        error.setErrorStatus(HttpStatus.UNAUTHORIZED);
        error.setErrorTime(LocalDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }
}
