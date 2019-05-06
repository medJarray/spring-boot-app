package com.spring.app.spring5webapp.repository;

import com.spring.app.spring5webapp.entity.Employer;
import com.spring.app.spring5webapp.repositories.EmployerRepository;
import com.spring.app.spring5webapp.service.DataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest(showSql = false)
@EnableJpaRepositories(basePackages = "com.spring.app.spring5webapp.repositories")
public class EmployerRepositoryTest {

    @Autowired
    private EmployerRepository employerRepository;


    @Test
    public void given_EmployerExist_When_findByMatricule_Then_getEmployer() {
        //  arrange
        Employer employer = DataProvider.getEmployer();

        //  act
        Employer byMatricule = employerRepository.findByMatricule(employer.getMatricule());

        //  assert
        assertThat(byMatricule.getMatricule()).isEqualTo(employer.getMatricule());
    }
}
