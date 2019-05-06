package com.spring.app.spring5webapp.services.impl;

import com.spring.app.spring5webapp.entity.Employer;
import com.spring.app.spring5webapp.model.CreateEmployer;
import com.spring.app.spring5webapp.model.EmployerElement;
import com.spring.app.spring5webapp.repositories.EmployerRepository;
import com.spring.app.spring5webapp.services.EmployerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@CacheConfig(cacheNames = {"allEmployer"}) // tells Spring where to store cache for this class
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployerServiceImpl implements EmployerService {

    private final EmployerRepository employerRepository;

    private final ModelMapper mapper;

    private void simulateSlowService() throws InterruptedException {
        Thread.sleep(3000L);
    }

    @Override
    @Cacheable
    public List<EmployerElement> getAllEmployer() throws InterruptedException {
        simulateSlowService();
        List<Employer> employers = employerRepository.findAll();
        return employers.stream().map(employer -> mapper.map(employer, EmployerElement.class)).collect(Collectors.toList());
    }

    @Override
    @Cacheable(cacheNames = "employer", key = "#name.toUpperCase()")
    public Optional<Employer> getEmployerByName(String name) {
        return Optional.ofNullable(employerRepository.findEmployersByName(name));
    }

    @Override
    @CachePut
    public EmployerElement createEmployer(CreateEmployer employerToCreate) {
        Employer employer = mapper.map(employerToCreate, Employer.class);
        Employer savedEmployer = employerRepository.save(employer);
        return mapper.map(savedEmployer, EmployerElement.class);
    }
}
