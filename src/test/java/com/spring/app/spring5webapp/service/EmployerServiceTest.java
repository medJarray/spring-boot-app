package com.spring.app.spring5webapp.service;

import com.spring.app.spring5webapp.model.Employer;
import com.spring.app.spring5webapp.repositories.EmployerRepository;
import com.spring.app.spring5webapp.services.impl.EmployerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@DataJpaTest(showSql = false)
@ComponentScan("com.spring.app.spring5webapp.services.impl")
public class EmployerServiceTest {


    @MockBean
    private EmployerRepository employerRepository;

    @Autowired
    private EmployerServiceImpl employerServiceImpl;

    @Test
    public void given_EmployerExist_When_findEmployerByName_Then_getEmployer() {
        //  arrange
        Employer employer = new Employer("Mohamed", "Jarray", "MJA14588", 2);
        when(employerRepository.findEmployersByName("Mohamed")).thenReturn(employer);

        //  act
        Optional<Employer> employerByName = employerServiceImpl.getEmployerByName("Mohamed");

        //  assert
        Employer employerFound = employerByName.get();
        assertThat(employerFound).extracting("firstName", "lastName", "matricule", "nbrTicketEnCharge")
                                 .contains(employerFound.getFirstName(), employerFound.getLastName(), employerFound.getMatricule(), employerFound.getNbrTicketEnCharge());

    }

    @Test
    public void given_NotExistingEmployer_When_findEmployerByName_Then_getEmployer() {
        //  arrange
        when(employerRepository.findEmployersByName("Mohamed")).thenReturn(null);

        //  act
        Optional<Employer> employerByName = employerServiceImpl.getEmployerByName(anyString());

        //  assert
        boolean present = employerByName.isPresent();
        assertThat(present).isFalse();
    }
}
