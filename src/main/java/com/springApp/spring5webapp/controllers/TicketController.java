package com.springApp.spring5webapp.controllers;


import com.springApp.spring5webapp.model.Ticket;
import com.springApp.spring5webapp.services.TicketService;
import com.springApp.spring5webapp.services.impl.TicketServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {

    private TicketService ticketService;

    @RequestMapping(value = "/allTickets", produces = "application/json")
    public List<Ticket> getAllTicket(){
        List<Ticket> ticketList = ticketService.getAllTicket();
        return ticketList;
    }
}
