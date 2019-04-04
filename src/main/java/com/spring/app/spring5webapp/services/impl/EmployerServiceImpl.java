package com.spring.app.spring5webapp.services.impl;

import com.spring.app.spring5webapp.entity.Employer;
import com.spring.app.spring5webapp.model.CreateEmployer;
import com.spring.app.spring5webapp.model.EmployerElement;
import com.spring.app.spring5webapp.repositories.EmployerRepository;
import com.spring.app.spring5webapp.services.EmployerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployerServiceImpl implements EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public List<EmployerElement> getAllEmployer() {
        List<Employer> employers = employerRepository.findAll();

        return employers.stream().map(employer -> mapper.map(employer, EmployerElement.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<Employer> getEmployerByName(String name) {
        return Optional.ofNullable(employerRepository.findEmployersByName(name));
    }

    @Override
    public EmployerElement createEmployer(CreateEmployer employerToCreate) {
        Employer employer = mapper.map(employerToCreate, Employer.class);
        Employer savedEmployer = employerRepository.save(employer);
        return mapper.map(savedEmployer, EmployerElement.class);
    }
}
