package com.dridco.inmuebles.ws.g7.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {})
@XmlRootElement(name = "publications")
public class ConsultarPublicacionResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @XmlElement(type = PublicationPair.class)
    private List<PublicationPair> publicaciones;

    public ConsultarPublicacionResponse() {
    }

    public ConsultarPublicacionResponse(List<PublicationPair> publicationPairs) {
        publicaciones = publicationPairs;
    }

    public List<PublicationPair> getPublicaciones() {
        return this.publicaciones;
    }

    public void setPublicaciones(List<PublicationPair> publicaciones) {
        this.publicaciones = publicaciones;
    }

}
