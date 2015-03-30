package com.dridco.inmuebles.ws.g7.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.common.collect.Lists;

/**
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "")
@XmlRootElement(name = "realEstates")
public class GetPublishedRealEstatesResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(type = RealEstateIds.class, name = "realEstate")
    private List<RealEstateIds> realEstateIdsList;

    public GetPublishedRealEstatesResponse(ConsultarPublicacionResponse publicacionResponse) {
        List<PublicationPair> publicaciones = publicacionResponse.getPublicaciones();
        this.realEstateIdsList = Lists.newArrayListWithCapacity(publicaciones.size());
        for (PublicationPair publicationPair : publicaciones) {
            this.realEstateIdsList.add(new RealEstateIds(publicationPair));
        }
    }

    public GetPublishedRealEstatesResponse() {
        // required by org.apache.cxf
    }

    public List<RealEstateIds> getRealEstateIdsList() {
        return this.realEstateIdsList;
    }

}
