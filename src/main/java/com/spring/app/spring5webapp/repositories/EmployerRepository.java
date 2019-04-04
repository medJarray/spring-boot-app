package com.spring.app.spring5webapp.repositories;

import com.spring.app.spring5webapp.entity.Employer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployerRepository extends PagingAndSortingRepository<Employer, Long> {
    List<Employer> findAll();

    @Query(value = "select empl from Employer empl where empl.firstName = :name")
    Employer findEmployersByName(@Param("name") String name);
}
