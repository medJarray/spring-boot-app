package com.spring.app.spring5webapp.services.impl;


import com.spring.app.spring5webapp.entity.Ticket;
import com.spring.app.spring5webapp.repositories.TicketRepository;
import com.spring.app.spring5webapp.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public List<Ticket> getAllTicket() {
        return ticketRepository.findAll();
    }
}
