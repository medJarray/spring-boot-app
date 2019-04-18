package com.spring.app.spring5webapp.services;

import com.spring.app.spring5webapp.entity.Employer;
import com.spring.app.spring5webapp.model.CreateEmployer;
import com.spring.app.spring5webapp.model.EmployerElement;

import java.util.List;
import java.util.Optional;

public interface EmployerService {

    List<EmployerElement> getAllEmployer() throws InterruptedException;

    Optional<Employer> getEmployerByName(String name);

    EmployerElement createEmployer(CreateEmployer employerToCreate);
}
