package com.spring.app.spring5webapp.api;

import com.spring.app.spring5webapp.common.ApiEndpoints;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;


public interface VersionApi {

    @ApiOperation(value = "Get version.")
    @GetMapping(value = ApiEndpoints.VERSION, produces = "application/json")
    String getVersion();
}
