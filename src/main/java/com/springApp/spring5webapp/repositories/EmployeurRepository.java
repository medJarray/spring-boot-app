package com.springApp.spring5webapp.repositories;

import com.springApp.spring5webapp.model.Employeur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeurRepository extends PagingAndSortingRepository<Employeur,Long> {
    List<Employeur> findAll();

    @Query(value = "select empl from Employeur empl where empl.firstName = :name")
    Employeur findEmployeursByName(@Param("name") String name);
}
