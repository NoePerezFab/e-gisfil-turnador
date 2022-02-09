
package com.gisnet.egisfil.controller;

import com.couchbase.client.core.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.core.deps.com.fasterxml.jackson.databind.ObjectMapper; 
import com.gisnet.egisfil.RepositoryService.ServiciosRepositoryService;
import com.gisnet.egisfil.RepositoryService.Sucursal_Secuencia_sericiosRepositoryService;
import com.gisnet.egisfil.RepositoryService.TicketRepositoryService;
import com.gisnet.egisfil.domain.Sucursal_secuencia_servicios;
import com.gisnet.egisfil.domain.Ticket;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    public String addTicket(@RequestBody Ticket ticket,HttpServletRequest req) throws JsonProcessingException{
        ticket.setHora_llegada(System.currentTimeMillis());
        ticket.setType("ticket");
        ticket.setTipo_Servicio(ticket.getServicio().getTipo_servicio());
        ticket.setStatus(1);
        ticket.setTipo_Servicio(ticket.getServicio().getTipo_servicio());
        List<Sucursal_secuencia_servicios> sec = repoSecuencia.findByClaveServicio(ticket.getServicio().getClave(),java.sql.Date.valueOf(java.time.LocalDate.now()),ticket.getId_sucursal());
        if(sec.isEmpty()){
            Sucursal_secuencia_servicios secuencia = new Sucursal_secuencia_servicios();
            secuencia.setType("secuencia");
            secuencia.setId("secuencia::"+java.time.LocalDate.now()+"_"+ticket.getServicio().getClave()+"_"+ticket.getId_sucursal());
            secuencia.setFecha(""+java.sql.Date.valueOf(java.time.LocalDate.now()));
            secuencia.setClave_servicio(ticket.getServicio().getClave());
            secuencia.setId_sucursal(ticket.getId_sucursal());
            secuencia.setSecuencia(2);
            repoSecuencia.create(secuencia);
            ticket.setTurno(ticket.getServicio().getClave() + " 1");
            
        }else{
            Sucursal_secuencia_servicios secuencia = sec.get(0);
            ticket.setTurno(ticket.getServicio().getClave() + " "+ secuencia.getSecuencia());
            secuencia.setSecuencia(secuencia.getSecuencia() + 1);
            repoSecuencia.update(secuencia);
        }
        ticket.setId(ticket.getId_sucursal()+"::ticket::"+ticket.getHora_llegada());
        if(repo.findOne(ticket.getId()).isPresent()){
            return "Error";
        }
        Ticket nuevo = repo.create(ticket);
        
        //Llamado a display
         RestTemplate restT = new RestTemplate();
        HttpHeaders h = new HttpHeaders();
        h.setContentType(MediaType.APPLICATION_JSON);
        String url = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+"/displayback/api/call";
        HttpEntity<String> entity = new HttpEntity<>(maper.writeValueAsString(nuevo),h);
        ResponseEntity<?> result = restT.exchange(url,HttpMethod.POST,entity,String.class);
        
        
        return maper.writeValueAsString(nuevo);
        
    }
}
