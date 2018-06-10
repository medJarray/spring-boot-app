package com.springApp.spring5webapp.services;


import com.springApp.spring5webapp.model.Ticket;
import com.springApp.spring5webapp.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    public List<Ticket> getAllTicket(){
        List<Ticket> ticketList = ticketRepository.findAll();
        return ticketList;
    }
}
