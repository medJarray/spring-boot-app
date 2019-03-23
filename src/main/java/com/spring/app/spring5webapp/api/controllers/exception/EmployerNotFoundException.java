package com.spring.app.spring5webapp.api.controllers.exception;

public class EmployerNotFoundException extends RuntimeException {

    public EmployerNotFoundException(String name) {
        super("Could not find employee " + name);
    }
}