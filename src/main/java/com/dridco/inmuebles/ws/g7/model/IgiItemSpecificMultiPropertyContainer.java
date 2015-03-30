package com.dridco.inmuebles.ws.g7.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType
public class IgiItemSpecificMultiPropertyContainer implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlAttribute(required = true)
    private String name;

    @XmlElement(required = false, type = IgiItemSpecificMultiProperty.class, nillable = false, name = "property")
    private List<IgiItemSpecificMultiProperty> properties = new ArrayList<>();

    public String getName() {
        return this.name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public List<IgiItemSpecificMultiProperty> getProperties() {
        return this.properties;
    }

    public void setProperties(List<IgiItemSpecificMultiProperty> properties) {
        this.properties = properties;
    }

}
