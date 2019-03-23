package com.spring.app.spring5webapp.api;

import com.spring.app.spring5webapp.common.ApiEndpoints;
import com.spring.app.spring5webapp.model.Employer;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EmployerApi {

    @ApiOperation(value = "Get list of all employers.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    @GetMapping(value = ApiEndpoints.EMPLOYERS, produces = "application/json")
    List<Employer> getAllEmployers();

    @ApiOperation(value = "Get employer by name.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    @GetMapping(value = ApiEndpoints.EMPLOYERS_SEARCH_BY_NAME, produces = "application/json")
    Employer getEmployerByName(@RequestParam("name") String name);
}
