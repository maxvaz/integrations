package com.dridco.inmuebles.ws.g7.model;

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

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "proceso")
public class Process {

    @XmlElement(required = false, type = PostProviderCredential.class, nillable = false, name = "credenciales")
    private PostProviderCredential postProviderCredential;

    @XmlElement(required = false, type = Publication.class, nillable = false, name = "publicacion")
    private List<Publication> publication;

    public List<Publication> getPublication() {
        return this.publication;
    }

    public void setPublication(List<Publication> publication) {
        this.publication = publication;
    }

    public PostProviderCredential getPostProviderCredential() {
        return this.postProviderCredential;
    }

    public void setPostProviderCredential(PostProviderCredential postProviderCredential) {
        this.postProviderCredential = postProviderCredential;
    }

}
