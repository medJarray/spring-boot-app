package com.spring.app.spring5webapp.services.impl;


import com.spring.app.spring5webapp.entity.Employer;
import com.spring.app.spring5webapp.entity.Ticket;
import com.spring.app.spring5webapp.repositories.EmployerRepository;
import com.spring.app.spring5webapp.repositories.TicketRepository;
import com.spring.app.spring5webapp.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TicketServiceImpl implements TicketService {

    private final EmployerRepository employerRepository;

    private final TicketRepository ticketRepository;

    @Override
    public List<Ticket> getAllTicket() {
        return ticketRepository.findAll();
    }

    @Override
    public Employer assignTicketToEmployer(String employerMatricule, Long ticketId) {
        Employer employerFound = employerRepository.findByMatricule(employerMatricule);
        Optional<Ticket> ticketFound = ticketRepository.findById(ticketId);
        if (ticketFound.isPresent()) {
            employerFound.addTicket(ticketFound.get());
            employerRepository.save(employerFound);
        }
        return employerFound;
    }

    @Override
    public Employer removeTicketToEmployer(String employerMatricule, Long ticketId) {
        Employer employerFound = employerRepository.findByMatricule(employerMatricule);
        Optional<Ticket> ticketFound = ticketRepository.findById(ticketId);
        if (ticketFound.isPresent()) {
            employerFound.removeTicket(ticketFound.get());
            employerRepository.save(employerFound);
        }
        return employerFound;
    }
}
