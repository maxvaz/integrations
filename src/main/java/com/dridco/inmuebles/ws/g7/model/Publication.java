package com.dridco.inmuebles.ws.g7.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author ppalazzi
 * 
 */

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "publicacion", namespace = "http://service.g7.ws.inmuebles.dridco.com/")
public class Publication implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(required = false, type = Aviso.class, nillable = false, name = "aviso")
    private Aviso ad;

    @XmlElement(required = false, type = String.class, nillable = false)
    private String usuario;

    public Aviso getAd() {
        return this.ad;
    }

    public void setAd(Aviso ad) {
        this.ad = ad;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
