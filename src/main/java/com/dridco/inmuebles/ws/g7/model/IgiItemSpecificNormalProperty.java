package com.dridco.inmuebles.ws.g7.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
@XmlType
public class IgiItemSpecificNormalProperty extends IgiItemSpecificProperty {

    private static final long serialVersionUID = 1L;

    @XmlAttribute(required = true)
    private String name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String nombre) {
        this.name = nombre;
    }

    @Override
    public boolean isMulti() {
        return false;
    }

}
