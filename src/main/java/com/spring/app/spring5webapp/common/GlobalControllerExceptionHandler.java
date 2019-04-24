package com.spring.app.spring5webapp.common;

import com.spring.app.spring5webapp.common.json.builder.JsonResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice()
public class GlobalControllerExceptionHandler {

    @Autowired
    private JsonResponseBuilder jsonResponseBuilder;

    /**
     * Permet d'intercepter la validation des controlleurs Spring sur les attributs annotés avec @Valid et de retourner
     * directement une reponse HTTP contenant l'ensemble des erreurs de validation.
     * Voir https://docs.spring.io/spring/docs/current/spring-framework-reference/html/validation.html#validation-introduction
     *
     * @param ex l'exception contenant les erreurs de validation (ex.getBindingResult())
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleBadHeaderParams(MethodArgumentNotValidException ex) {
        return jsonResponseBuilder.error(ex.getBindingResult()).build();
    }


}
