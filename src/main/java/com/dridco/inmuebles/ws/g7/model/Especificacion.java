package com.dridco.inmuebles.ws.g7.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "especificacion", propOrder = { "nombre", "valor" })
public class Especificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String nombre;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String valor;

    public String getNombre() {
        return this.nombre;
    }

    public String getValor() {
        return this.valor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }

}
