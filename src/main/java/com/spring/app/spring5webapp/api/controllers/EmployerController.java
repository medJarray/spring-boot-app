package com.spring.app.spring5webapp.api.controllers;

import com.spring.app.spring5webapp.api.EmployerApi;
import com.spring.app.spring5webapp.api.controllers.exception.EmployerNotFoundException;
import com.spring.app.spring5webapp.model.Employer;
import com.spring.app.spring5webapp.services.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployerController implements EmployerApi {

    @Autowired
    private EmployerService employerService;

    public List<Employer> getAllEmployers() {
        return employerService.getAllEmployer();
    }

    public Employer getEmployerByName(@RequestParam("name") String name) {
        return employerService.getEmployerByName(name)
                              .orElseThrow(() -> new EmployerNotFoundException(name));
    }
}
