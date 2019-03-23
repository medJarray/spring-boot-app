package com.spring.app.spring5webapp.services;

import com.spring.app.spring5webapp.model.Employer;

import java.util.List;
import java.util.Optional;

public interface EmployerService {

    List<Employer> getAllEmployer();

    Optional<Employer> getEmployerByName(String name);
}
