package com.spring.app.spring5webapp.api;

import com.spring.app.spring5webapp.common.ApiEndpoints;
import com.spring.app.spring5webapp.model.Ticket;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface TicketApi {

    @GetMapping(value = ApiEndpoints.TICKETS, produces = "application/json")
    List<Ticket> getAllTicket();

}
