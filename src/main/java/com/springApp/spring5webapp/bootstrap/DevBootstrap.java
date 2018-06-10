package com.springApp.spring5webapp.bootstrap;

import com.springApp.spring5webapp.model.Employeur;
import com.springApp.spring5webapp.model.Ticket;
import com.springApp.spring5webapp.repositories.EmployeurRepository;
import com.springApp.spring5webapp.repositories.TicketRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private EmployeurRepository employeurRepository;
    private TicketRepository ticketRepository;

    public DevBootstrap(EmployeurRepository employeurRepository, TicketRepository ticketRepository) {
        this.employeurRepository = employeurRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initDataBase();
    }

    // Initailiser le BD avec un bouchon
    private void initDataBase(){
        System.out.print("Initialise Data Base ----------------------->  ");

        Employeur empl_1 = new Employeur("Mohamed", "Jarray", "MJA14588",2);
        Employeur empl_2 = new Employeur("Alice", "Johnason", "AJO45008", 0);
        Employeur empl_3 = new Employeur("Elisa", "Quaston", "EQU162705", 0);
        Employeur empl_4 = new Employeur("Kevin", "Bokin", "KBO145889", 1);

        Ticket ticket_1 = new Ticket("Probleme lors de la recuperation des PP","EPR",0,false);
        Ticket ticket_2 = new Ticket("Popin bloqante lors de validation de crédit conso","CDR",0.25f,true, "Aiguillage");
        Ticket ticket_3 = new Ticket("NPE recherche PM","SRT",0.5f,true, "Assistant");
        Ticket ticket_4 = new Ticket("Erreur de mapping des donneés","IM",1.5f,true, "Analyse");

        empl_1.getListeTicket().add(ticket_3);
        empl_1.getListeTicket().add(ticket_4);
        empl_4.getListeTicket().add(ticket_2);

        ticket_2.setEmployeur(empl_4);
        ticket_3.setEmployeur(empl_1);
        ticket_4.setEmployeur(empl_1);

        List<Employeur> listEmployeurs = Arrays.asList(empl_1, empl_2, empl_3, empl_4);
        List<Ticket> listTickets = Arrays.asList(ticket_1, ticket_2, ticket_3, ticket_4);

        employeurRepository.saveAll(listEmployeurs);
        ticketRepository.saveAll(listTickets);
    }
}
