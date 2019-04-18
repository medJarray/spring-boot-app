package com.spring.app.spring5webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Spring5webappApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring5webappApplication.class, args);
    }
}
