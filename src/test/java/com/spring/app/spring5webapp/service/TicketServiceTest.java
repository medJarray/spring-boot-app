package com.spring.app.spring5webapp.service;

import com.spring.app.spring5webapp.configuration.MapperConfig;
import com.spring.app.spring5webapp.entity.Employer;
import com.spring.app.spring5webapp.entity.Ticket;
import com.spring.app.spring5webapp.repositories.EmployerRepository;
import com.spring.app.spring5webapp.repositories.TicketRepository;
import com.spring.app.spring5webapp.services.TicketService;
import com.spring.app.spring5webapp.services.impl.TicketServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@DataJpaTest(showSql = false)
@ComponentScan("com.spring.app.spring5webapp.services.impl")
@Import({MapperConfig.class})
public class TicketServiceTest {

    @MockBean
    private EmployerRepository employerRepository;

    @MockBean
    private TicketRepository ticketRepository;

    @Autowired
    private TicketService ticketService = new TicketServiceImpl(employerRepository, ticketRepository);


    @Test
    public void given_EmployerExist_When_removeTicketToEmployer_Then_employerHasMinusTicket() {
        //  arrange
        Employer employer = DataProvider.getEmployer();
        Ticket ticket = DataProvider.getTicket();

        when(employerRepository.findByMatricule(employer.getMatricule())).thenReturn(employer);
        when(ticketRepository.findById(ticket.getId())).thenReturn(java.util.Optional.ofNullable(ticket));
        ticketService.assignTicketToEmployer(employer.getMatricule(), ticket.getId());

        //  act
        Employer employerByName = ticketService.removeTicketToEmployer(employer.getMatricule(), ticket.getId());

        //  assert
        assertThat(employerByName.getTickets().size()).isEqualTo(0);

    }

    @Test
    public void given_EmployerExist_When_assignTicketToEmployer_Then_employerHasPlusTicket() {
        //  arrange
        Employer employer = DataProvider.getEmployer();
        Ticket ticket = DataProvider.getTicket();

        when(employerRepository.findByMatricule(employer.getMatricule())).thenReturn(employer);
        when(ticketRepository.findById(ticket.getId())).thenReturn(java.util.Optional.ofNullable(ticket));

        //  act
        Employer employerByName = ticketService.assignTicketToEmployer(employer.getMatricule(), ticket.getId());

        //  assert
        assertThat(employerByName.getTickets().size()).isEqualTo(1);
    }
}
