package com.spring.app.spring5webapp.api.controllers;

import com.spring.app.spring5webapp.api.VersionApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController implements VersionApi {

    public String getVersion() {
        return "1.0";
    }
}
