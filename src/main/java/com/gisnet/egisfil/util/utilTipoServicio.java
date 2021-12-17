
package com.gisnet.egisfil.util;

import java.io.Serializable;


public class utilTipoServicio implements Serializable{
    private String tipo_servicio;

    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public utilTipoServicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }
    
}
