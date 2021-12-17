
package com.gisnet.egisfil.RepositoryService;

import com.gisnet.egisfil.domain.Sucursal_secuencia_servicios;
import com.gisnet.egisfil.repository.Sucursal_secuencia_serviciosRepository;
import com.gisnet.egisfil.service.Sucursal_secuencia_serviciosService;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Sucursal_Secuencia_sericiosRepositoryService implements Sucursal_secuencia_serviciosService{

    @Autowired
    Sucursal_secuencia_serviciosRepository repo;
    
    @Override
    public Optional<Sucursal_secuencia_servicios> findOne(String id) {
        return repo.findById(id);
    }

    @Override
    public List<Sucursal_secuencia_servicios> findAll() {
        List<Sucursal_secuencia_servicios> lista = new ArrayList<>();
        Iterator it = repo.findAll().iterator();
        while(it.hasNext()){
            lista.add((Sucursal_secuencia_servicios)it.next());
        }
        return lista;
    }

    @Override
    public Sucursal_secuencia_servicios create(Sucursal_secuencia_servicios tipoServicio) {
        return repo.save(tipoServicio);
    }

    @Override
    public Sucursal_secuencia_servicios update(Sucursal_secuencia_servicios tipoServicio) {
        return repo.save(tipoServicio);
    }

    @Override
    public List<Sucursal_secuencia_servicios> findByClaveServicio(String clave_servicio,Date fecha) {
        List<Sucursal_secuencia_servicios> lista = new ArrayList<>();
        Iterator it = repo.findByCalveServicio(clave_servicio,fecha).iterator();
        while(it.hasNext()){
            lista.add((Sucursal_secuencia_servicios)it.next());
            
        }
        
        return lista;
    }
    
    
    
}
