package com.navent.integrations.igi.model.repository;

import static java.util.Optional.ofNullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryPostMappingRepository implements PostMappingRepository {

    private final Map<String, Long> mappings;

    public InMemoryPostMappingRepository() {
        mappings = new HashMap<String, Long>();
    }

    private String key(Long providerId, String providerUserId, String postId) {
        return providerId + "" + postId;
    }

    @Override
    public Optional<Long> mapToNavPlatId(Long providerId, String providerUserId, String postId) {
        return ofNullable(mappings.get(key(providerId, providerUserId, postId)));
    }

    @Override
    public void addMapping(Long providerId, String providerUserId, String providerPostId, Long navPlatPostId) {
        mappings.put(key(providerId, providerUserId, providerPostId), navPlatPostId);
    }
}
