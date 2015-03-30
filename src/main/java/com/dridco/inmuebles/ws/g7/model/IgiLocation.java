package com.dridco.inmuebles.ws.g7.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlTransient
public abstract class IgiLocation implements Serializable {

    private static final long serialVersionUID = 1L;

    public abstract String getAlturaCalle();

    public abstract String getCoordenadaLatitud();

    public abstract String getCoordenadaLongitud();

    public abstract String getDepto();

    public abstract String getEntreCalle1();

    public abstract String getEntreCalle2();

    public abstract Integer getIdUbicacion();

    public abstract String getNombreCalle();

    public abstract String getOtraUbicacion();

    public abstract String getPiso();

    public abstract String getNombreUrbanizacion();

    public abstract Boolean getMostrar();

    public abstract String getTipoCalle();

    public abstract String getDireccion();

    public abstract String getCodigoPostal();

    public abstract void setCoordenadaLatitud(String coordenadaLatitud);

    public abstract void setCoordenadaLongitud(String coordenadaLongitud);

}
