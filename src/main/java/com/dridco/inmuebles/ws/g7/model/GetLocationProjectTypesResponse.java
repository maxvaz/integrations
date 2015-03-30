package com.dridco.inmuebles.ws.g7.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "")
@XmlRootElement(name = "projectTypes")
public class GetLocationProjectTypesResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(type = String.class, name = "projectType")
    private List<String> projectTypes;

    public GetLocationProjectTypesResponse(List<String> projectTypes) {
        this.projectTypes = projectTypes;
    }

    public GetLocationProjectTypesResponse() {
        // required by org.apache.cxf
    }

    public List<String> getProjectTypes() {
        return this.projectTypes;
    }

}
