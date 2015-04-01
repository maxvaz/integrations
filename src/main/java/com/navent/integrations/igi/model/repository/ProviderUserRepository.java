package com.navent.integrations.igi.model;

import java.util.Optional;

public interface ProviderUserRepository {

    Optional<Long> mapToNavPlatId(Long providerId, String providerUserId);

}
