package com.spring.app.spring5webapp.api;

import com.spring.app.spring5webapp.common.ApiEndpoints;
import com.spring.app.spring5webapp.model.Employer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EmployerApi {

    @GetMapping(value = ApiEndpoints.EMPLOYERS, produces = "application/json")
    List<Employer> getAllEmployers();

    @GetMapping(value = ApiEndpoints.EMPLOYERS_SEARCH_BY_NAME, produces = "application/json")
    Employer getEmployerByName(@RequestParam("name") String name);
}
