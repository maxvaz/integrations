package com.dridco.inmuebles.ws.g7.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author pfenoglio
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
@XmlType(propOrder = { "nombreCalle", "alturaCalle", "piso", "depto", "entreCalle1", "entreCalle2",
        "coordenadaLatitud", "coordenadaLongitud", "idUbicacion", "otraUbicacion", "tipoCalle", "nombreUrbanizacion",
        "mostrar", "direccion", "codigoPostal" })
public class Ubicacion extends IgiLocation {

    private static final long serialVersionUID = 1L;

    @XmlElement(required = true, type = String.class, nillable = false)
    private String nombreCalle;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String alturaCalle;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String piso;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String depto;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String entreCalle1;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String entreCalle2;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String coordenadaLatitud;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String coordenadaLongitud;
    @XmlElement(required = true, type = Integer.class, nillable = false)
    private Integer idUbicacion;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String otraUbicacion;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String tipoCalle;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String nombreUrbanizacion;
    @XmlElement(required = false, type = Boolean.class, nillable = false)
    private Boolean mostrar;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String direccion;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String codigoPostal;

    @Override
    public String getAlturaCalle() {
        return this.alturaCalle;
    }

    @Override
    public String getCoordenadaLatitud() {
        return this.coordenadaLatitud;
    }

    @Override
    public String getCoordenadaLongitud() {
        return this.coordenadaLongitud;
    }

    @Override
    public String getDepto() {
        return this.depto;
    }

    @Override
    public String getEntreCalle1() {
        return this.entreCalle1;
    }

    @Override
    public String getEntreCalle2() {
        return this.entreCalle2;
    }

    @Override
    public Integer getIdUbicacion() {
        return this.idUbicacion;
    }

    @Override
    public String getNombreCalle() {
        return this.nombreCalle;
    }

    @Override
    public String getOtraUbicacion() {
        return this.otraUbicacion;
    }

    @Override
    public String getPiso() {
        return this.piso;
    }

    @Override
    public String getNombreUrbanizacion() {
        return this.nombreUrbanizacion;
    }

    public void setAlturaCalle(String alturaCalle) {
        this.alturaCalle = alturaCalle;
    }

    @Override
    public void setCoordenadaLatitud(String coordenadaLatitud) {
        this.coordenadaLatitud = coordenadaLatitud;
    }

    @Override
    public void setCoordenadaLongitud(String coordenadaLongitud) {
        this.coordenadaLongitud = coordenadaLongitud;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public void setEntreCalle1(String entreCalle1) {
        this.entreCalle1 = entreCalle1;
    }

    public void setEntreCalle2(String entreCalle2) {
        this.entreCalle2 = entreCalle2;
    }

    public void setIdUbicacion(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    public void setOtraUbicacion(String otraUbicacion) {
        this.otraUbicacion = otraUbicacion;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public void setNombreUrbanizacion(String nombreUrbanizacion) {
        this.nombreUrbanizacion = nombreUrbanizacion;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }

    public void setMostrar(Boolean mostrar) {
        this.mostrar = mostrar;
    }

    @Override
    public Boolean getMostrar() {
        return this.mostrar;
    }

    public void setTipoCalle(String tipoCalle) {
        this.tipoCalle = tipoCalle;
    }

    @Override
    public String getTipoCalle() {
        return this.tipoCalle;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String getDireccion() {
        return this.direccion;
    }

    @Override
    public String getCodigoPostal() {
        return this.codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

}
