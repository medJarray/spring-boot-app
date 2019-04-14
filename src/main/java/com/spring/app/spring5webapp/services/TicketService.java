package com.spring.app.spring5webapp.services;

import com.spring.app.spring5webapp.entity.Employer;
import com.spring.app.spring5webapp.entity.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> getAllTicket();

    Employer assignTicketToEmployer(String employerMatricule, Long ticketId);

    Employer removeTicketToEmployer(String employerMatricule, Long ticketId);
}
