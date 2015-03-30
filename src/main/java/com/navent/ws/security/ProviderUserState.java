package com.navent.ws.security;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ctorres
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
public enum ProviderUserState {

    ACTIVE(), DISABLED(), SUSPENDED();

    private ProviderUserState() {
    }

    public boolean isEnabled() {
        return this != DISABLED;
    }

    public static Set<ProviderUserState> getEnabledStates() {
        Set<ProviderUserState> states = new HashSet<>();
        for (ProviderUserState state : values()) {
            if (state.isEnabled()) {
                states.add(state);
            }
        }
        return states;
    }

}
