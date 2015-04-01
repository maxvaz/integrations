package com.navent.integrations.igi.ws;

import static com.dridco.inmuebles.ws.g7.service.RealEstateService.EN_PROVIDER_PARAM;
import static com.dridco.inmuebles.ws.g7.service.RealEstateService.EN_USER_PARAM;
import static com.dridco.inmuebles.ws.g7.service.RealEstateService.ES_PROVIDER_PARAM;
import static com.dridco.inmuebles.ws.g7.service.RealEstateService.ES_USER_PARAM;

import org.apache.cxf.message.Message;

public class AuthenticationMessage {

    private final EnhancedMessage enhancedMessage;

    public AuthenticationMessage(Message message) {
        enhancedMessage = new EnhancedMessage(message);
    }

    public String getPassword() {
        return enhancedMessage.getHeader("password");
    }

    public Long getProviderId() {
        return Long.valueOf(enhancedMessage.getHeader(ES_PROVIDER_PARAM, EN_PROVIDER_PARAM));
    }

    public String getUser() {
        return enhancedMessage.getHeader(ES_USER_PARAM, EN_USER_PARAM);
    }

}
