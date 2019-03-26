package com.spring.app.spring5webapp.api.controllers;


import com.spring.app.spring5webapp.api.TicketApi;
import com.spring.app.spring5webapp.model.Ticket;
import com.spring.app.spring5webapp.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController implements TicketApi {

    @Autowired
    private TicketService ticketService;

    public List<Ticket> getAllTicket() {
        return ticketService.getAllTicket();
    }
}
