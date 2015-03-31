package com.navent.integrations.igi.navplat.adapters;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.dridco.inmuebles.ws.g7.model.Aviso;
import com.dridco.inmuebles.ws.g7.model.Especificacion;

@Component
public class AdaptSpecifications {

    public Collection<Especificacion> adaptAvisoSpecification(Aviso aviso) {
        throw new UnsupportedOperationException();

    }

    public Collection<String[]> getSpecificationData(Aviso aviso) {
        throw new UnsupportedOperationException();
    }
}
