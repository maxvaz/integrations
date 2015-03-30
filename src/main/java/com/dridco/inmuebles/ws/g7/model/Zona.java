package com.dridco.inmuebles.ws.g7.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Zona implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nombre;

    public Zona() {
    }

    public Zona(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.nombre == null) ? 0 : this.nombre.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!Zona.class.isInstance(obj)) {
            return false;
        }

        Zona that = (Zona) obj;

        return new EqualsBuilder().append(this.id, that.id).append(this.nombre, that.nombre).isEquals();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
