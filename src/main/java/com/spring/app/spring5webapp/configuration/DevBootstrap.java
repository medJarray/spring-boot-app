package com.spring.app.spring5webapp.configuration;

import com.spring.app.spring5webapp.entity.Employer;
import com.spring.app.spring5webapp.entity.Ticket;
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
        return (String... args) -> {
            logger.info("Initialise Data Base ----------------------->  ");

            Ticket ticket1 = new Ticket().builder()
                                         .descriptif("Probleme lors de la recuperation des PP")
                                         .perimetre("EPR")
                                         .tempsTraitement(0.25f)
                                         .isClos(true)
                                         .build();

            Ticket ticket2 = new Ticket().builder()
                                         .descriptif("Popin bloqante lors de validation de crédit conso")
                                         .perimetre("CDR")
                                         .tempsTraitement(0.25f)
                                         .isClos(true)
                                         .typeIntervention("Aiguillage")
                                         .build();

            Ticket ticket3 = new Ticket().builder()
                                         .descriptif("NPE recherche PM")
                                         .perimetre("SRT")
                                         .tempsTraitement(0.5f)
                                         .isClos(true)
                                         .typeIntervention("Assistant")
                                         .build();

            Ticket ticket4 = new Ticket().builder()
                                         .descriptif("Erreur de mapping des donneés")
                                         .perimetre("IM")
                                         .tempsTraitement(1.5f)
                                         .isClos(true)
                                         .typeIntervention("Analyse")
                                         .build();

            Employer employer1 = new Employer().builder()
                                               .firstName("Mohamed")
                                               .lastName("Jarray")
                                               .matricule("MJA14588")
                                               .nbrTicketEnCharge(2)
                                               .listeTicket(Arrays.asList(ticket3, ticket4))
                                               .build();

            Employer employer2 = new Employer().builder()
                                               .firstName("Alice")
                                               .lastName("Johnason")
                                               .matricule("AJO45008")
                                               .nbrTicketEnCharge(0)
                                               .build();

            Employer employer3 = new Employer().builder()
                                               .firstName("Elisa")
                                               .lastName("Quaston")
                                               .matricule("EQU162705")
                                               .nbrTicketEnCharge(0)
                                               .build();

            Employer employer4 = new Employer().builder()
                                               .firstName("Kevin")
                                               .lastName("Bokin")
                                               .matricule("KBO145889")
                                               .nbrTicketEnCharge(2)
                                               .listeTicket(Arrays.asList(ticket2))
                                               .build();

            List<Employer> listEmployers = Arrays.asList(employer1, employer2, employer3, employer4);
            List<Ticket> listTickets = Arrays.asList(ticket1, ticket2, ticket3, ticket4);

            employerRepository.saveAll(listEmployers);
            ticketRepository.saveAll(listTickets);
        };
    }
}
