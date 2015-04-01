package com.navent.integrations.igi.model.repository;

import java.util.Optional;

public interface PostMappingRepository {

    public Optional<Long> mapToNavPlatId(Long providerId, String providerUserId, String providerPostId);

    public void addMapping(Long providerId, String providerUserId, String providerPostId, Long navPlatPostId);

}
