package com.dridco.inmuebles.ws.g7.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
@XmlType(propOrder = { "otherLocationName", "streetName", "betweenStreet1", "betweenStreet2", "buildingNumber",
        "streetType", "address", "floor", "room", "latitude", "longitude", "urbanizationName", "show", "postalCode" })
public class IgiProjectLocation extends IgiLocation {

    private static final long serialVersionUID = 1L;

    @XmlAttribute(required = true)
    private Integer id;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String betweenStreet1;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String betweenStreet2;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String streetName;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String buildingNumber;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String streetType;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String address;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String floor;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String room;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String latitude;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String longitude;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String otherLocationName;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String urbanizationName;
    @XmlElement(required = false, type = Boolean.class, nillable = false)
    private Boolean show;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String postalCode;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public String getAlturaCalle() {
        return getBuildingNumber();
    }

    @Override
    public String getCoordenadaLatitud() {
        return getLatitude();
    }

    @Override
    public String getCoordenadaLongitud() {
        return getLongitude();
    }

    @Override
    public String getDepto() {
        return getRoom();
    }

    @Override
    public String getEntreCalle1() {
        return getBetweenStreet1();
    }

    @Override
    public String getEntreCalle2() {
        return getBetweenStreet2();
    }

    @Override
    public Integer getIdUbicacion() {
        return getId();
    }

    @Override
    public String getNombreCalle() {
        return getStreetName();
    }

    @Override
    public String getOtraUbicacion() {
        return getOtherLocationName();
    }

    @Override
    public String getPiso() {
        return getFloor();
    }

    @Override
    public String getNombreUrbanizacion() {
        return getUrbanizationName();
    }

    @Override
    public Boolean getMostrar() {
        return getShow();
    }

    @Override
    public String getTipoCalle() {
        return getStreetType();
    }

    @Override
    public String getDireccion() {
        return getAddress();
    }

    @Override
    public String getCodigoPostal() {
        return getPostalCode();
    }

    public String getStreetName() {
        return this.streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getBuildingNumber() {
        return this.buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getFloor() {
        return this.floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoom() {
        return this.room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBetweenStreet1() {
        return this.betweenStreet1;
    }

    public void setBetweenStreet1(String betweenStreet1) {
        this.betweenStreet1 = betweenStreet1;
    }

    public String getBetweenStreet2() {
        return this.betweenStreet2;
    }

    public void setBetweenStreet2(String betweenStreet2) {
        this.betweenStreet2 = betweenStreet2;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOtherLocationName() {
        return this.otherLocationName;
    }

    public void setOtherLocationName(String otherLocationName) {
        this.otherLocationName = otherLocationName;
    }

    public String getStreetType() {
        return this.streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    public String getUrbanizationName() {
        return this.urbanizationName;
    }

    public void setUrbanizationName(String urbanizationName) {
        this.urbanizationName = urbanizationName;
    }

    public Boolean getShow() {
        return this.show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public void setCoordenadaLatitud(String coordenadaLatitud) {
        setLatitude(coordenadaLatitud);
    }

    @Override
    public void setCoordenadaLongitud(String coordenadaLongitud) {
        setLongitude(coordenadaLongitud);
    }

}
