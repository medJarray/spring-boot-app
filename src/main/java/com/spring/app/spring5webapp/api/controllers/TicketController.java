package com.spring.app.spring5webapp.api.controllers;


import com.spring.app.spring5webapp.api.TicketApi;
import com.spring.app.spring5webapp.entity.Ticket;
import com.spring.app.spring5webapp.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TicketController implements TicketApi {

    private final TicketService ticketService;

    public List<Ticket> getAllTicket() {
        return ticketService.getAllTicket();
    }
}
