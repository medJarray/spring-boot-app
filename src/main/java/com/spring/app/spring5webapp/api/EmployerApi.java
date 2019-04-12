package com.spring.app.spring5webapp.api;

import com.spring.app.spring5webapp.common.ApiEndpoints;
import com.spring.app.spring5webapp.model.CreateEmployer;
import com.spring.app.spring5webapp.model.EmployerElement;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EmployerApi {

    @ApiOperation(value = "", notes = "Create a new Employer", response = EmployerElement.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "POL created", response = EmployerElement.class),
            @ApiResponse(code = 500, message = "Unexpected error", response = EmployerElement.class)})
    @PostMapping(value = ApiEndpoints.EMPLOYERS,
            produces = {"application/json"},
            consumes = {"application/json"})
    ResponseEntity<EmployerElement> createEmployer(@ApiParam(value = "", required = true) @RequestBody CreateEmployer employerToCreate);

    @ApiOperation(value = "Get list of all employers.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    @GetMapping(value = ApiEndpoints.EMPLOYERS, produces = "application/json")
    ResponseEntity<List<EmployerElement>> getAllEmployers();

    @ApiOperation(value = "Get employer by name.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    @GetMapping(value = ApiEndpoints.EMPLOYERS_SEARCH_BY_NAME, produces = "application/json")
    ResponseEntity<EmployerElement> getEmployerByName(@RequestParam("name") String name);
}