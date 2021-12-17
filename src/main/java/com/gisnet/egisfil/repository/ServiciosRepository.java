
package com.gisnet.egisfil.repository;

import com.gisnet.egisfil.domain.Servicios;
import java.util.List;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiciosRepository extends CouchbaseRepository<Servicios, String>{
    @Query("#{#n1ql.selectEntity} WHERE  `servicio_cliente` = #{[0]} AND #{#n1ql.filter} ")
    List<Servicios> findServicios(boolean isCliente);
    
    @Query("#{#n1ql.selectEntity} WHERE  `servicio_cliente` = #{[0]} AND `tipo_servicio` = #{[1]} AND #{#n1ql.filter} ")
    List<Servicios> findSubservicios(boolean isCliente,String tipo_servicio);
    
}
