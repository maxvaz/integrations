package com.navent.integrations.igi.model;

import java.util.Optional;

public interface PostMappingRepository {

    Optional<Long> mapToNavPlatId(Long providerId, String providerUserId, String providerPostId);

    void addMapping(Long providerId, String providerUserId, String providerPostId, Long navPlatPostId);

    Iterable<PostMapping> getAllMappings(Long providerId, String providerUserId);

}
