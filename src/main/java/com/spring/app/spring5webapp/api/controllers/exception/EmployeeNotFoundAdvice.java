package com.spring.app.spring5webapp.api.controllers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class EmployeeNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(EmployerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employerNotFoundExceptionHandler(EmployerNotFoundException ex) {
        return ex.getMessage();
    }
}
