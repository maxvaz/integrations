package com.dridco.inmuebles.ws.g7.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author ppalazzi
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "igiContact")
public class IgiPostContact implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(required = false, type = Long.class, nillable = false)
    private Long adId;

    @XmlElement(required = false, type = String.class, nillable = false)
    private String adIdProvider;

    @XmlElement(required = false, type = String.class, nillable = false)
    private String date;

    @XmlElement(required = false, type = String.class, nillable = false)
    private String contactName;

    @XmlElement(required = false, type = String.class, nillable = false)
    private String areaPhoneNumber;

    @XmlElement(required = false, type = String.class, nillable = false)
    private String phoneNumber;

    @XmlElement(required = false, type = String.class, nillable = false)
    private String email;

    @XmlElement(required = false, type = String.class, nillable = false)
    private String comments;

    public Long getAdId() {
        return this.adId;
    }

    public void setAdId(Long adId) {
        this.adId = adId;
    }

    public String getAdIdProvider() {
        return this.adIdProvider;
    }

    public void setAdIdProvider(String adIdProvider) {
        this.adIdProvider = adIdProvider;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContactName() {
        return this.contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getAreaPhoneNumber() {
        return this.areaPhoneNumber;
    }

    public void setAreaPhoneNumber(String areaPhoneNumber) {
        this.areaPhoneNumber = areaPhoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
