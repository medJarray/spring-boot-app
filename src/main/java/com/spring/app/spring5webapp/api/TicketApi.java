package com.spring.app.spring5webapp.api;

import com.spring.app.spring5webapp.common.ApiEndpoints;
import com.spring.app.spring5webapp.model.Ticket;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface TicketApi {

    @ApiOperation(value = "Get all ticket.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    @GetMapping(value = ApiEndpoints.TICKETS, produces = "application/json")
    List<Ticket> getAllTicket();

}
