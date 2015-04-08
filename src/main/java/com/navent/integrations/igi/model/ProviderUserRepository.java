package com.navent.integrations.igi.model;

import java.util.Optional;

public interface ProviderUserRepository {

    Optional<Long> mapToNavPlatId(Long postProviderId, String providerUserId);

    void addMapping(Long postProviderId, String providerUserId, Long navPlatPostId);

    Optional<PostProviderUser> get(Long postProviderId, String user);
    // if (!ProviderUserState.ACTIVE.equals(providerUser.getImportStats())) {
    // throw new RuntimeException("Provider user " + user + " is disabled.");
    // }

}
