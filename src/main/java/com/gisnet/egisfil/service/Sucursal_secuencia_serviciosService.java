
package com.gisnet.egisfil.service;


import com.gisnet.egisfil.domain.Sucursal_secuencia_servicios;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface Sucursal_secuencia_serviciosService {
    Optional<Sucursal_secuencia_servicios> findOne(String id);
    List<Sucursal_secuencia_servicios> findAll();
    Sucursal_secuencia_servicios create(Sucursal_secuencia_servicios tipoServicio);
    Sucursal_secuencia_servicios update(Sucursal_secuencia_servicios tipoServicio);
    public List<Sucursal_secuencia_servicios> findByClaveServicio(String clave_servicio,Date fecha,String id_sucursal);
}
