package com.navent.integrations.igi.ws;

import com.dridco.inmuebles.zz.RealEstateTypeEnum;

/**
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
public interface ProviderUserValidationService {

    /**
     * Sends notification if post addition limits have been reached.
     * 
     * @return <code>true</code> if limits have not yet been reached.
     */
    boolean validatePostAddition(Long postProviderId, String providerUserId, RealEstateTypeEnum realEstateType);

}
