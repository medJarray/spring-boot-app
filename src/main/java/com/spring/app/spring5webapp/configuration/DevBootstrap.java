package com.spring.app.spring5webapp.configuration;

import com.spring.app.spring5webapp.model.Employer;
import com.spring.app.spring5webapp.model.Ticket;
import com.spring.app.spring5webapp.repositories.EmployerRepository;
import com.spring.app.spring5webapp.repositories.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DevBootstrap {


    private static final Logger logger = LoggerFactory.getLogger(DevBootstrap.class);


    @Bean
    CommandLineRunner initDataBase(EmployerRepository employerRepository, TicketRepository ticketRepository) {
        return args -> {
            logger.info("Initialise Data Base ----------------------->  ");

            Employer employer1 = new Employer("Mohamed", "Jarray", "MJA14588", 2);
            Employer employer2 = new Employer("Alice", "Johnason", "AJO45008", 0);
            Employer employer3 = new Employer("Elisa", "Quaston", "EQU162705", 0);
            Employer employer4 = new Employer("Kevin", "Bokin", "KBO145889", 1);

            Ticket ticket1 = new Ticket("Probleme lors de la recuperation des PP", "EPR", 0, false);
            Ticket ticket2 = new Ticket("Popin bloqante lors de validation de crédit conso", "CDR", 0.25f, true, "Aiguillage");
            Ticket ticket3 = new Ticket("NPE recherche PM", "SRT", 0.5f, true, "Assistant");
            Ticket ticket4 = new Ticket("Erreur de mapping des donneés", "IM", 1.5f, true, "Analyse");

            employer1.getListeTicket().add(ticket3);
            employer1.getListeTicket().add(ticket4);
            employer4.getListeTicket().add(ticket2);

            ticket2.setEmployer(employer4);
            ticket3.setEmployer(employer1);
            ticket4.setEmployer(employer1);

            List<Employer> listEmployers = Arrays.asList(employer1, employer2, employer3, employer4);
            List<Ticket> listTickets = Arrays.asList(ticket1, ticket2, ticket3, ticket4);

            employerRepository.saveAll(listEmployers);
            ticketRepository.saveAll(listTickets);
        };
    }
}
