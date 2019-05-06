package com.spring.app.spring5webapp.api;

import com.spring.app.spring5webapp.common.json.builder.JsonResponseBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class ConfigUnitTest {

    @Bean
    public JsonResponseBuilder jrb() {
        return new JsonResponseBuilder();
    }
}