package com.spring.app.spring5webapp.api.controllers.exception;

public class EmployerNotFoundException extends RuntimeException {

    public EmployerNotFoundException(String message) {
        super(message);
    }
}