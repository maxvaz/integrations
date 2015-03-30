package com.dridco.inmuebles.ws.g7.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
@XmlType(propOrder = { "givenName", "familyName", "email", "phone1", "phone2", "contactHours", "additionalEmails" })
public class IgiProjectContact extends IgiContact {

    private static final long serialVersionUID = 1L;

    @XmlElement(required = true, type = String.class, nillable = false)
    private String givenName;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String familyName;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String email;
    @XmlElement(required = true, type = IgiProjectPhone.class, nillable = false)
    private IgiProjectPhone phone1;
    @XmlElement(required = false, type = IgiProjectPhone.class, nillable = false)
    private IgiProjectPhone phone2;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String contactHours;
    @XmlElement(required = false, type = String.class, nillable = false)
    private List<String> additionalEmails;

    public String getGivenName() {
        return this.givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public IgiProjectPhone getPhone1() {
        return this.phone1;
    }

    public void setPhone1(IgiProjectPhone phone1) {
        this.phone1 = phone1;
    }

    public IgiProjectPhone getPhone2() {
        return this.phone2;
    }

    public void setPhone2(IgiProjectPhone phone2) {
        this.phone2 = phone2;
    }

    public String getContactHours() {
        return this.contactHours;
    }

    public void setContactHours(String contactHours) {
        this.contactHours = contactHours;
    }

    @Override
    public String getApellido() {
        return getFamilyName();
    }

    @Override
    public String getHorarioContacto() {
        return getContactHours();
    }

    @Override
    public String getNombre() {
        return getGivenName();
    }

    @Override
    public IgiPhone getIgiPhone1() {
        return getPhone1();
    }

    @Override
    public IgiPhone getIgiPhone2() {
        return getPhone2();
    }

    @Override
    public List<String> getAdditionalEmails() {
        return this.additionalEmails;
    }

    public void setAdditionalEmails(List<String> additionalEmails) {
        this.additionalEmails = additionalEmails;
    }

    @Override
    public void adaptContactPhone() {
        this.phone1.setNumber(this.phone1.adaptPhone());
        if (this.phone2 != null) {
            this.phone2.setNumber(this.phone2.adaptPhone());
        }
    }

}
