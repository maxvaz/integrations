package com.dridco.inmuebles.ws.g7.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "medida", propOrder = { "ambiente", "valor" })
public class Medida implements Serializable {
    private static final long serialVersionUID = 1L;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String ambiente;

    @XmlElement(required = true, type = String.class, nillable = false)
    private String valor;

    public Medida() {
        this.ambiente = "";
        this.valor = "";
    }

    public Medida(String label, String value) {
        this.ambiente = label;
        this.valor = value;
    }

    public String getAmbiente() {
        return this.ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getValor() {
        return this.valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}
