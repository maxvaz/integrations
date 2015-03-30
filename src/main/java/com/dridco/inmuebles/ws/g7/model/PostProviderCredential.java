package com.dridco.inmuebles.ws.g7.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author ppalazzi
 * 
 */

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "credenciales", namespace = "http://service.g7.ws.inmuebles.dridco.com/")
public class PostProviderCredential {

    @XmlElement(required = false, type = String.class, nillable = false)
    private String proveedor;

    @XmlElement(required = false, type = String.class, nillable = false)
    private String password;

    public String getProveedor() {
        return this.proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
