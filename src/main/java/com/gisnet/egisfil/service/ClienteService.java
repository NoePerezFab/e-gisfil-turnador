
package com.gisnet.egisfil.service;


import com.gisnet.egisfil.domain.Cliente;
import java.util.List;
import java.util.Optional;


public interface ClienteService {
    Optional<Cliente> findOne(String id);
    List<Cliente> findAll();
    Cliente create(Cliente cliente);
    Cliente update(Cliente cliente);
}
