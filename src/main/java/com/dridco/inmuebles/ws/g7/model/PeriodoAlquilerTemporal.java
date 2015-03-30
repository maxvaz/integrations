package com.dridco.inmuebles.ws.g7.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author rrodriguez
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "periodoAlquilerTemporal", propOrder = { "periodo", "tipoMoneda", "precio", "consultaPrecio" })
public class PeriodoAlquilerTemporal implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(required = true, type = String.class, nillable = false)
    private String periodo;

    @XmlElement(required = false, type = String.class, nillable = false)
    private String tipoMoneda;

    @XmlElement(required = false, type = Long.class, nillable = false)
    private Long precio;

    @XmlElement(required = false, type = boolean.class, nillable = false)
    private boolean consultaPrecio;

    public PeriodoAlquilerTemporal() {

    }

    public PeriodoAlquilerTemporal(String periodo, String tipoMoneda, Long precio, boolean consultaPrecio) {
        super();
        this.periodo = periodo;
        this.tipoMoneda = tipoMoneda;
        this.precio = precio;
        this.consultaPrecio = consultaPrecio;
    }

    public PeriodoAlquilerTemporal(String periodo, boolean consultaPrecio) {
        super();
        this.periodo = periodo;
        this.consultaPrecio = consultaPrecio;
    }

    public PeriodoAlquilerTemporal(String periodo) {
        super();
        this.periodo = periodo;
    }

    public String getPeriodo() {
        return this.periodo;
    }

    public String getTipoMoneda() {
        return this.tipoMoneda;
    }

    public Long getPrecio() {
        return this.precio;
    }

    public boolean getConsultaPrecio() {
        return this.consultaPrecio;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public void setConsultaPrecio(boolean consultaPrecio) {
        this.consultaPrecio = consultaPrecio;
    }

}
