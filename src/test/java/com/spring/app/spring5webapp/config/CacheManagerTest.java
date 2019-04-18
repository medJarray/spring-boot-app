package com.spring.app.spring5webapp.config;


import com.spring.app.spring5webapp.configuration.CachingConfig;
import com.spring.app.spring5webapp.entity.Employer;
import com.spring.app.spring5webapp.repositories.EmployerRepository;
import com.spring.app.spring5webapp.services.EmployerService;
import com.spring.app.spring5webapp.services.impl.EmployerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"com.spring.app.spring5webapp.configuration", "com.spring.app.spring5webapp.services"})
@DataJpaTest(showSql = false)
@EnableJpaRepositories(basePackages = "com.spring.app.spring5webapp.repositories")
@Import(CachingConfig.class)
public class CacheManagerTest {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private EmployerService employerService = new EmployerServiceImpl(employerRepository, mapper);

    @Test
    public void validateCache() {
        Cache topEmployerCache = cacheManager.getCache("employer");
        assertThat(topEmployerCache).isNotNull();
        topEmployerCache.clear(); // Simple test assuming the cache is empty
        assertThat(topEmployerCache.get("MOHAMED")).isNull();
        Optional<Employer> employerByName = employerService.getEmployerByName("Mohamed");
        assertThat((Employer) topEmployerCache.get("MOHAMED").get()).isEqualTo(employerByName.get());
    }


}
