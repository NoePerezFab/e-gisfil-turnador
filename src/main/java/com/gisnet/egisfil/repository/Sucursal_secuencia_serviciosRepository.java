
package com.gisnet.egisfil.repository;

import com.gisnet.egisfil.domain.Sucursal_secuencia_servicios;
import java.util.Date;
import java.util.List;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Sucursal_secuencia_serviciosRepository extends CouchbaseRepository<Sucursal_secuencia_servicios, String> {
    
    @Query("#{#n1ql.selectEntity} WHERE  `clave_servicio` = '#{[0]}' AND `fecha` = '#{[1]}' AND #{#n1ql.filter} ")
    public List<Sucursal_secuencia_servicios> findByCalveServicio(String clave_servicio,Date fecha);
}
