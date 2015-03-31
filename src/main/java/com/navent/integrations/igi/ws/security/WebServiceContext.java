package com.navent.integrations.igi.ws.security;

import org.springframework.stereotype.Component;

@Component
public class WebServiceContext {

    private final ThreadLocal<ProviderUser> providerUser = new ThreadLocal<ProviderUser>();

    public ProviderUser getProviderUser() {
        return providerUser.get();
    }

    public void setProviderUser(ProviderUser providerUser) {
        this.providerUser.set(providerUser);
    }

}
