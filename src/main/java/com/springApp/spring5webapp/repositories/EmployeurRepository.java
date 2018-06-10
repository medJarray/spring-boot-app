package com.springApp.spring5webapp.repositories;

import com.springApp.spring5webapp.model.Employeur;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeurRepository extends PagingAndSortingRepository<Employeur,Long> {

}
