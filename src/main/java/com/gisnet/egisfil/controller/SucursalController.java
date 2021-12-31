
package com.gisnet.egisfil.controller;

import com.couchbase.client.core.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.core.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.gisnet.egisfil.RepositoryService.SucursalRepositoryService;
import com.gisnet.egisfil.domain.Sucursal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SucursalController {
    @Autowired
    private SucursalRepositoryService repo;
    
    private ObjectMapper maper = new ObjectMapper();
    
    @GetMapping("/api/getsucursales")
    public String getSucursales() throws JsonProcessingException{
        List<Sucursal> lista = new ArrayList<>();
        List<Sucursal> sucursales = repo.findAll();
        for(Sucursal s : sucursales){
            Sucursal suc = new Sucursal();
            suc.setId(s.getId());
            suc.setClave(s.getClave());
            suc.setNombre(s.getNombre());
            lista.add(suc);
        }
        return maper.writeValueAsString(lista);
    }
    
    @PostMapping("/api/getsucursal")
    public String getSucursal(@RequestBody Sucursal sucursal) throws JsonProcessingException{
        if(repo.findOne(sucursal.getId()).isEmpty()){
            return "Error al seleccionar sucursal";
        }
        sucursal = repo.findOne(sucursal.getId()).get();
        return maper.writeValueAsString(sucursal);
    }
}
