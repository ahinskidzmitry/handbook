package com.ahinski.handbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for application error handling
 * 
 * @author Dzmitry Ahinski
 * 
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityDoesNotExistException.class)
    public ResponseEntity<String> handleEntityDoesNotExistExceptions(final EntityDoesNotExistException entityDoesNotExistException) {
        return new ResponseEntity<>(entityDoesNotExistException.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentExceptions(final IllegalArgumentException illegalArgumentException) {
        return new ResponseEntity<>(illegalArgumentException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleExceptions(final Exception exception) {
        System.out.println(exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
