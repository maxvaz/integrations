package com.navent.integrations.igi.ws;

import org.springframework.stereotype.Service;

import com.dridco.inmuebles.zz.RealEstateTypeEnum;

@Service
public class ProviderUserValidationServiceImpl implements ProviderUserValidationService {

    @Override
    public boolean validatePostAddition(Long postProviderId, String providerUserId, RealEstateTypeEnum realEstateType) {
        throw new UnsupportedOperationException();
    }
}