package com.spring.app.spring5webapp.api.controllers;

import com.spring.app.spring5webapp.api.EmployerApi;
import com.spring.app.spring5webapp.api.controllers.exception.EmployerNotFoundException;
import com.spring.app.spring5webapp.model.CreateEmployer;
import com.spring.app.spring5webapp.model.EmployerElement;
import com.spring.app.spring5webapp.services.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployerController implements EmployerApi {

    private final MessageSource messageSource;

    private final EmployerService employerService;


    @Override
    public ResponseEntity<EmployerElement> createEmployer(CreateEmployer employerToCreate) {
        EmployerElement employer = employerService.createEmployer(employerToCreate);
        return new ResponseEntity(employer, null, HttpStatus.CREATED);
    }

    public ResponseEntity<List<EmployerElement>> getAllEmployers() throws InterruptedException {
        List<EmployerElement> allEmployer = employerService.getAllEmployer();
        return new ResponseEntity(allEmployer, null, allEmployer.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);

    }

    public ResponseEntity<EmployerElement> getEmployerByName(@RequestParam("name") String name) {
        return new ResponseEntity(employerService.getEmployerByName(name)
                                                 .orElseThrow(() -> {
                                                     String notFoundEmployer = messageSource.getMessage("notFoundEmployer", null, LocaleContextHolder.getLocale());
                                                     return new EmployerNotFoundException(MessageFormat.format(notFoundEmployer, name));
                                                 }), null, HttpStatus.OK);
    }
}
