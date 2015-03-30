package com.dridco.inmuebles.ws.g7.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author pfenoglio@dridco.com
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
@XmlType(name = "contacto", propOrder = { "nombre", "apellido", "email", "telefono1", "telefono2", "horarioContacto",
        "emailAdicionales" })
public class Contacto extends IgiContact {
    private static final long serialVersionUID = 2L;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String nombre;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String apellido;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String email;
    @XmlElement(required = true, type = Telefono.class, nillable = false, name = "telefono1")
    private Telefono telefono1;
    @XmlElement(required = false, type = Telefono.class, nillable = false, name = "telefono2")
    private Telefono telefono2;
    @XmlElement(required = true, type = String.class, nillable = false)
    private String horarioContacto;
    @XmlElement(required = false, type = String.class, nillable = false)
    private List<String> emailAdicionales;

    @Override
    public String getApellido() {
        return this.apellido;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getHorarioContacto() {
        return this.horarioContacto;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    public Telefono getTelefono1() {
        return this.telefono1;
    }

    @Override
    public IgiPhone getIgiPhone1() {
        return getTelefono1();
    }

    public Telefono getTelefono2() {
        return this.telefono2;
    }

    @Override
    public IgiPhone getIgiPhone2() {
        return getTelefono2();
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHorarioContacto(String horarioContacto) {
        this.horarioContacto = horarioContacto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono1(Telefono telefono1) {
        this.telefono1 = telefono1;
    }

    public void setTelefono2(Telefono telefono2) {
        this.telefono2 = telefono2;
    }

    public void setEmailAdicionales(List<String> emailAdicionales) {
        this.emailAdicionales = emailAdicionales;
    }

    public List<String> getEmailAdicionales() {
        return this.emailAdicionales;
    }

    @Override
    public List<String> getAdditionalEmails() {
        return getEmailAdicionales();
    }

    @Override
    public void adaptContactPhone() {
        this.telefono1.setNumeroTelefono(this.telefono1.adaptPhone());
        if (this.telefono2 != null) {
            this.telefono2.setNumeroTelefono(this.telefono2.adaptPhone());
        }
    }
}
