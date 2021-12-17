
package com.gisnet.egisfil.controller;

import com.couchbase.client.core.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.core.deps.com.fasterxml.jackson.databind.ObjectMapper; 
import com.gisnet.egisfil.RepositoryService.ServiciosRepositoryService;
import com.gisnet.egisfil.RepositoryService.Sucursal_Secuencia_sericiosRepositoryService;
import com.gisnet.egisfil.RepositoryService.TicketRepositoryService;
import com.gisnet.egisfil.domain.Sucursal_secuencia_servicios;
import com.gisnet.egisfil.domain.Ticket;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TicketController {
    @Autowired
    TicketRepositoryService repo;
    @Autowired
    ServiciosRepositoryService repoServicios;
    @Autowired
    Sucursal_Secuencia_sericiosRepositoryService repoSecuencia;
    
    private ObjectMapper maper = new ObjectMapper();
    
    @GetMapping("/api/tickets")
    public String getTickets() throws JsonProcessingException{
        List<Ticket> lista = repo.findAll();
        return maper.writeValueAsString(lista);
    }
    
    @PostMapping("/api/addticket")
    public String addTicket(@RequestBody Ticket ticket) throws JsonProcessingException{
        ticket.setHora_llegada(System.currentTimeMillis());
        ticket.setType("ticket");
        List<Sucursal_secuencia_servicios> sec = repoSecuencia.findByClaveServicio(ticket.getServicio().getClave(),java.sql.Date.valueOf(java.time.LocalDate.now()));
        if(sec.isEmpty()){
            Sucursal_secuencia_servicios secuencia = new Sucursal_secuencia_servicios();
            secuencia.setType("secuencia");
            secuencia.setId("secuencia::"+java.time.LocalDate.now());
            secuencia.setFecha(""+java.sql.Date.valueOf(java.time.LocalDate.now()));
            secuencia.setClave_servicio(ticket.getServicio().getClave());
            secuencia.setSecuencia(2);
            repoSecuencia.create(secuencia);
            ticket.setTurno(ticket.getServicio().getClave() + " 1");
        }else{
            Sucursal_secuencia_servicios secuencia = sec.get(0);
            ticket.setTurno(ticket.getServicio().getClave() + " "+ secuencia.getSecuencia());
            secuencia.setSecuencia(secuencia.getSecuencia() + 1);
            repoSecuencia.update(secuencia);
        }
        ticket.setId("ticket::"+ticket.getHora_llegada());
        if(repo.findOne(ticket.getId()).isPresent()){
            return "Error";
        }
        return maper.writeValueAsString(repo.create(ticket));
        
    }
}
