package com.dridco.inmuebles.ws.g7.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "realEstateType", "realEstateSubtype", "operation", "priceCurrency", "priceFrom", "priceTo",
        "garageOption", "garagePrice", "blueprintUrl", "comments", "roomMeasures", "properties", "multiProperties" })
public class IgiProjectUnit implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(required = true, type = String.class, nillable = false)
    private String realEstateType;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String realEstateSubtype;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String operation;
    @XmlElement(required = false, type = String.class, nillable = false, name = "blueprint")
    private List<String> blueprintUrl;
    @XmlElement(required = false, type = Boolean.class, nillable = false)
    private Boolean garageOption; // hacer un XmlAdapter para aceptar TRUE? (luego usar XmlElement y XmlJavaTypeAdapter)
    @XmlElement(required = false, type = IgiItemSpecificNormalProperty.class, nillable = false, name = "property")
    private List<IgiItemSpecificNormalProperty> properties = new ArrayList<>();
    @XmlElement(required = false, type = IgiItemSpecificMultiPropertyContainer.class, nillable = false, name = "multiProperty")
    private List<IgiItemSpecificMultiPropertyContainer> multiProperties = new ArrayList<>();
    @XmlElement(required = false, type = Long.class, nillable = false)
    private Long priceFrom;
    @XmlElement(required = false, type = Long.class, nillable = false)
    private Long priceTo;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String priceCurrency;
    @XmlElement(required = false, type = Long.class, nillable = false)
    private Long garagePrice;
    @XmlElement(required = false, type = IgiRoomMeasure.class, nillable = false, name = "roomMeasure")
    private List<IgiRoomMeasure> roomMeasures;
    @XmlElement(required = false, type = String.class, nillable = false)
    private String comments;

    public String getRealEstateType() {
        return this.realEstateType;
    }

    public void setRealEstateType(String realEstateType) {
        this.realEstateType = realEstateType;
    }

    public String getRealEstateSubtype() {
        return this.realEstateSubtype;
    }

    public void setRealEstateSubtype(String subtipoPropiedad) {
        this.realEstateSubtype = subtipoPropiedad;
    }

    public List<IgiItemSpecificNormalProperty> getProperties() {
        return this.properties;
    }

    public void setProperties(List<IgiItemSpecificNormalProperty> properties) {
        this.properties = properties;
    }

    public Boolean getGarageOption() {
        return this.garageOption;
    }

    public void setGarageOption(Boolean garageOption) {
        this.garageOption = garageOption;
    }

    public List<String> getBlueprintUrl() {
        return this.blueprintUrl;
    }

    public void setBlueprintUrl(List<String> blueprintUrl) {
        this.blueprintUrl = blueprintUrl;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Long getPriceFrom() {
        return this.priceFrom;
    }

    public void setPriceFrom(Long priceFrom) {
        this.priceFrom = priceFrom;
    }

    public Long getPriceTo() {
        return this.priceTo;
    }

    public void setPriceTo(Long priceTo) {
        this.priceTo = priceTo;
    }

    public String getPriceCurrency() {
        return this.priceCurrency;
    }

    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    public Long getGaragePrice() {
        return this.garagePrice;
    }

    public void setGaragePrice(Long garagePrice) {
        this.garagePrice = garagePrice;
    }

    public List<IgiRoomMeasure> getRoomMeasures() {
        return this.roomMeasures;
    }

    public void setRoomMeasures(List<IgiRoomMeasure> roomMeasures) {
        this.roomMeasures = roomMeasures;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<IgiItemSpecificMultiPropertyContainer> getMultiProperties() {
        return this.multiProperties;
    }

    public void setMultiProperties(List<IgiItemSpecificMultiPropertyContainer> multiProperties) {
        this.multiProperties = multiProperties;
    }

}
