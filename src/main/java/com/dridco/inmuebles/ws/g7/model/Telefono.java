package com.dridco.inmuebles.ws.g7.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author pfenoglio@dridco.com
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 * @author pmedici@dridco.com
 */
@XmlType(name = "telefono", propOrder = { "codigoArea", "numeroTelefono", "extension" })
public class Telefono extends IgiPhone {
    private static final long serialVersionUID = 2L;

    @XmlElement(required = true, type = String.class, nillable = false)
    private String codigoArea;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String numeroTelefono;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String extension;

    @Override
    public String getCodigoArea() {
        return this.codigoArea;
    }

    @Override
    public String getExtension() {
        return this.extension;
    }

    @Override
    public String getNumeroTelefono() {
        return this.numeroTelefono;
    }

    public void setCodigoArea(String codigoArea) {
        this.codigoArea = codigoArea;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public String adaptPhone() {
        return this.numeroTelefono.replace(SPACE_SEPARATOR, EMPTY);
    }

}
