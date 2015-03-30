package com.dridco.inmuebles.ws.g7.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "publication", propOrder = { "idAvisoZonaProp", "idEntidadIgi" })
public class PublicationPair implements Serializable {
    private static final long serialVersionUID = 1L;
    @XmlElement(type = String.class)
    private String idAvisoZonaProp;
    @XmlElement(type = String.class)
    private String idEntidadIgi;

    public String getIdAvisoZonaProp() {
        return this.idAvisoZonaProp;
    }

    public void setIdAvisoZonaProp(String idAvisoZonaProp) {
        this.idAvisoZonaProp = idAvisoZonaProp;
    }

    public String getIdEntidadIgi() {
        return this.idEntidadIgi;
    }

    public void setIdEntidadIgi(String idEntidadIgi) {
        this.idEntidadIgi = idEntidadIgi;
    }

}
