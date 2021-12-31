
package com.gisnet.egisfil.domain;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class Sucursal_secuencia_servicios implements Serializable{
    @Id
    private String id;
    
    @Field
    private String fecha;
    
    @Field
    private String clave_servicio;
    
    @Field
    private String id_sucursal;
    
    @Field
    private int secuencia;
    
    @Field
    private String type;

    public String getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(String id_sucursal) {
        this.id_sucursal = id_sucursal;
    }
    
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    

    public String getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getClave_servicio() {
        return clave_servicio;
    }

    public int getSecuencia() {
        return secuencia;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setClave_servicio(String clave_servicio) {
        this.clave_servicio = clave_servicio;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }
    
    
    
}
