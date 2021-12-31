
package com.gisnet.egisfil.domain;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class Ticket implements Serializable{
    @Id
    private String id;
   
    @Field
    private Long hora_llegada;
    
    @Field
    private String tiempo_espera;
    
    @Field
    private String type;
    
    @Field
    private Cliente cliente;
    
    @Field
    private String turno;
    
    @Field
    private Servicios servicio;
    
    @Field
    private String tipo_Servicio;

    @Field
    private int status;
    
    @Field
    private String id_sucursal;

    public String getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(String id_sucursal) {
        this.id_sucursal = id_sucursal;
    }
    
    

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    public String getTipo_Servicio() {
        return tipo_Servicio;
    }

    public void setTipo_Servicio(String tipo_Servicio) {
        this.tipo_Servicio = tipo_Servicio;
    }
    
    

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    
    
    public Servicios getServicio() {
        return servicio;
    }

    public void setServicio(Servicios servicio) {
        this.servicio = servicio;
    }
    
    

    public String getId() {
        return id;
    }

    public Long getHora_llegada() {
        return hora_llegada;
    }

    public String getTiempo_espera() {
        return tiempo_espera;
    }

    public String getType() {
        return type;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setHora_llegada(Long hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public void setTiempo_espera(String tiempo_espera) {
        this.tiempo_espera = tiempo_espera;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
