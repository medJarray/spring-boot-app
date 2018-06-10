package com.springApp.spring5webapp.controllers;


import com.springApp.spring5webapp.model.Ticket;
import com.springApp.spring5webapp.repositories.EmployeurRepository;
import com.springApp.spring5webapp.repositories.TicketRepository;
import com.springApp.spring5webapp.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @RequestMapping(value = "/allTickets", produces = "application/json")
    public List<Ticket> getAllTicket(){
        List<Ticket> ticketList = ticketService.getAllTicket();
        return ticketList;
    }
}
