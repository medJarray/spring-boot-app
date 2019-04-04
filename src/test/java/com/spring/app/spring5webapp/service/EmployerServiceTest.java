package com.spring.app.spring5webapp.service;

import com.spring.app.spring5webapp.configuration.MapperConfig;
import com.spring.app.spring5webapp.entity.Employer;
import com.spring.app.spring5webapp.model.EmployerElement;
import com.spring.app.spring5webapp.repositories.EmployerRepository;
import com.spring.app.spring5webapp.services.impl.EmployerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@DataJpaTest(showSql = false)
@ComponentScan("com.spring.app.spring5webapp.services.impl")
@Import({MapperConfig.class})
public class EmployerServiceTest {


    @MockBean
    private EmployerRepository employerRepository;

    @Autowired
    private EmployerServiceImpl employerServiceImpl;

    @Autowired
    ModelMapper mapper;


    @Test
    public void given_EmployerExist_When_findAllEmployer_Then_getEmployer() {
        //  arrange
        Employer employer1 = new Employer("Mohamed", "Jarray", "MJA14588", 2);
        Employer employer2 = new Employer("Mohamed-I", "Jarray", "MJA14568", 6);
        List<Employer> employerList = new ArrayList<>();
        employerList.add(employer1);
        employerList.add(employer2);
        when(employerRepository.findAll()).thenReturn(employerList);

        //  act
        List<EmployerElement> employerByName = employerServiceImpl.getAllEmployer();

        //  assert
        assertThat(employerByName).extracting("firstName", "lastName", "matricule", "nbrTicketEnCharge")
                                  .contains(tuple(employer1.getFirstName(), employer1.getLastName(), employer1.getMatricule(), employer1.getNbrTicketEnCharge()));

    }

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
