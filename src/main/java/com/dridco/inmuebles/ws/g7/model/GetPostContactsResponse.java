package com.dridco.inmuebles.ws.g7.model;

import java.util.ArrayList;
import java.util.List;

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
@XmlRootElement(name = "getPostContactsResponse")
public class GetPostContactsResponse {

    @XmlElement(required = false, type = IgiPostContact.class, nillable = false, name = "IgiContact")
    private List<IgiPostContact> igiPostContacts;

    private String errorDescription;

    public GetPostContactsResponse() {
        this.igiPostContacts = new ArrayList<IgiPostContact>();
    }

    public List<IgiPostContact> getIgiPostContacts() {
        return this.igiPostContacts;
    }

    public void setIgiPostContacts(List<IgiPostContact> postContacResult) {
        this.igiPostContacts = postContacResult;
    }

    public String getErrorDescription() {
        return this.errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
