package com.spring.app.spring5webapp.repositories;

import com.spring.app.spring5webapp.model.Ticket;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TicketRepository extends PagingAndSortingRepository<Ticket, Long> {
    List<Ticket> findAll();
}
