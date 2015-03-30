package com.dridco.inmuebles.ws.g7.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType
public class RealEstateIds implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlAttribute
    private String internalId;
    @XmlAttribute
    private String externalId;

    public RealEstateIds(PublicationPair publicationPair) {
        this.externalId = publicationPair.getIdEntidadIgi();
        this.internalId = publicationPair.getIdAvisoZonaProp();
    }

    public RealEstateIds() {
        // required by org.apache.cxf
    }

    public String getExternalId() {
        return this.externalId;
    }

    public String getInternalId() {
        return this.internalId;
    }

}
