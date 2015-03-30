package com.dridco.inmuebles.ws.g7.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlTransient
public abstract class IgiContact implements Serializable {
    /* TODO: esto debería ir a otra clase ya que tambien lo usan algunos command */
    public static final int ADDITIONAL_EMAIL_LIMIT = 10;
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public abstract String getApellido();

    public abstract String getEmail();

    public abstract String getHorarioContacto();

    public abstract String getNombre();

    public abstract IgiPhone getIgiPhone1();

    public abstract IgiPhone getIgiPhone2();

    public abstract List<String> getAdditionalEmails();

    public abstract void adaptContactPhone();

}
