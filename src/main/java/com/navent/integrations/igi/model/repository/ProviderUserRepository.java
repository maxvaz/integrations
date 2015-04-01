package com.navent.integrations.igi.model.repository;

import java.util.Optional;

import com.navent.integrations.igi.ws.security.ProviderUser;

public interface ProviderUserRepository {

    Optional<Long> mapToNavPlatId(Long postProviderId, String providerUserId);

    void addMapping(Long postProviderId, String providerUserId, Long navPlatPostId);

    Optional<ProviderUser> get(Long postProviderId, String user);
    // if (!ProviderUserState.ACTIVE.equals(providerUser.getImportStats())) {
    // throw new RuntimeException("Provider user " + user + " is disabled.");
    // }

}
