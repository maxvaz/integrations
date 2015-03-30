package com.dridco.inmuebles.ws.g7.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author pfenoglio
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlTransient
public abstract class IgiRealEstatePost implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Max Description Length allowed in IGI Publicator
     */
    public static final int MAX_DESCRIPTION_LENGTH = 5000;

    public abstract String getIdAvisoProveedor();

    public abstract void setIdAvisoProveedor(String idAvisoProveedor);

    public abstract IgiContact getIgiContact();

    public abstract List<String> getIgiAdditionalContactEmails();

    public abstract Long getIdAviso();

    public abstract String getTipoPropiedad();

    public abstract IgiLocation getIgiLocation();

    public abstract List<String> getUrlImagenes();

    public abstract void setIdAviso(Long idAviso);

    public abstract void setTipoPropiedad(String tipoPropiedad);

    // TODO: comment other setters?

    public abstract void setUrlImagenes(List<String> urlImagenes);

    public abstract String getPais();

    public abstract void setPais(String pais);

    public abstract Long getExpositionMethodType();

    public abstract Long getPostLabel();

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
