package com.navent.integrations.igi.navplat.adapters;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dridco.inmuebles.ws.g7.model.Zona;
import com.dridco.inmuebles.zz.BusinessDomain;
import com.navent.integrations.igi.navplat.NavPlatLocation;

@Component
public class LocationAdapter {

    public List<String> getUnitConcepts(Long valueOf, BusinessDomain businessDomain) {
        throw new UnsupportedOperationException();
    }

    public List<String> getProjectConcepts(Long locationId, BusinessDomain businessDomain) {
        throw new UnsupportedOperationException();
    }

    public List<Zona> getRealStateLocations(BusinessDomain businnesDomain) {
        throw new UnsupportedOperationException();
    }

    public List<Zona> adapt(List<NavPlatLocation> navPlatLocations) {
        throw new UnsupportedOperationException();
    }

}
