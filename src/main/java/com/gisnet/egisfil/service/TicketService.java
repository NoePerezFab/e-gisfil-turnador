
package com.gisnet.egisfil.service;


import com.gisnet.egisfil.domain.Ticket;
import java.util.List;
import java.util.Optional;


public interface TicketService {
    Optional<Ticket> findOne(String id);
    List<Ticket> findAll();
    Ticket create(Ticket ticket);
    Ticket update(Ticket ticket);
}
