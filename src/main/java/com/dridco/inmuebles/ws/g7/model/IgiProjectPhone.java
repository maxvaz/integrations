package com.dridco.inmuebles.ws.g7.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 * @author pmedici@dridco.com
 */
@XmlType
public class IgiProjectPhone extends IgiPhone {

    private static final long serialVersionUID = 1L;

    @XmlAttribute(required = true)
    private String areaCode;
    @XmlAttribute(required = true)
    private String number;
    @XmlAttribute(required = false)
    private String extension;

    public String getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public String getCodigoArea() {
        return getAreaCode();
    }

    @Override
    public String getNumeroTelefono() {
        return getNumber();
    }

    @Override
    public String adaptPhone() {
        return this.number.replace(SPACE_SEPARATOR, EMPTY);
    }

}
