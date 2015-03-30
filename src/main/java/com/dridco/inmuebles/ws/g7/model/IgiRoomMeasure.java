package com.dridco.inmuebles.ws.g7.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType
public class IgiRoomMeasure {

    @XmlAttribute(required = true)
    private String room;
    @XmlAttribute(required = true)
    private String measures;

    public String getRoom() {
        return this.room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getMeasures() {
        return this.measures;
    }

    public void setMeasures(String measures) {
        this.measures = measures;
    }

}
