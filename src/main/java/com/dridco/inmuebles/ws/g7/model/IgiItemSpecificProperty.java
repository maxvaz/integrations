package com.dridco.inmuebles.ws.g7.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlTransient
public abstract class IgiItemSpecificProperty implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlAttribute(required = true)
    private String value;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public abstract String getName();

    public String getValue() {
        return this.value;
    }

    public abstract void setName(String nombre);

    public void setValue(String valor) {
        this.value = valor;
    }

    public abstract boolean isMulti();

}
