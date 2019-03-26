package com.spring.app.spring5webapp.services.impl;

import com.spring.app.spring5webapp.model.Employer;
import com.spring.app.spring5webapp.repositories.EmployerRepository;
import com.spring.app.spring5webapp.services.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerServiceImpl implements EmployerService {

    @Autowired
    private EmployerRepository employerRepository;


    @Override
    public List<Employer> getAllEmployer() {
        return employerRepository.findAll();
    }

    @Override
    public Optional<Employer> getEmployerByName(String name) {
        return Optional.ofNullable(employerRepository.findEmployersByName(name));
    }
}
