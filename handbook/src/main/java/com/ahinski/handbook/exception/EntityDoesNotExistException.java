package com.ahinski.handbook.exception;

public class EntityDoesNotExistException extends RuntimeException {
    
    public EntityDoesNotExistException(String message) {
        super(message);
    }
}
