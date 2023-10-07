package com.example.fitnesstracker.Utils.Exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is annotated with @ControllerAdvice, which makes it a central point for exception handling across all
 * controller classes in the application. The @ExceptionHandler annotation is used to define the class of exception
 * it will catch and handle.
 *
 * @author Hervé Labrie-Durand
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = Logger.getLogger(GlobalExceptionHandler.class.getName());

    /**
     * This method handles IllegalArgumentExceptions that may be thrown within the application. When an
     * IllegalArgumentException is thrown, this handler catches the exception, logs the error message, and returns
     * a 400 Bad Request response with the error message in the body.
     *
     * @param e The IllegalArgumentException that was thrown.
     * @return A ResponseEntity with a 400 Bad Request status and the error message in the body.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        logger.log(Level.SEVERE, e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(ServerException.class)
    public ResponseEntity<String> handleDataAccessException(ServerException e) {
        logger.log(Level.SEVERE, e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}

