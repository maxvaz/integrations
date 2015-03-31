package com.navent.integrations.igi.model;

import java.util.Optional;

public interface PostMappingRepository {

    public Optional<Long> mapToNavPlatId(String providerPostId, Long providerId);

}
