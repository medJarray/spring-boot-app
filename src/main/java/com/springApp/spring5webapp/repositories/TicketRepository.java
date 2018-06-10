package com.springApp.spring5webapp.repositories;

import com.springApp.spring5webapp.model.Ticket;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TicketRepository extends PagingAndSortingRepository<Ticket,Long> {
    List<Ticket> findAll();
}
