package com.navent.integrations.igi.model.repository;

import static java.util.Optional.ofNullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.navent.integrations.igi.ws.security.PostProviderUser;

@Repository
public class InMemoryProviderUserRepository implements ProviderUserRepository {

    private final Map<String, Long> mappings;

    public InMemoryProviderUserRepository() {
        mappings = new HashMap<String, Long>();
    }

    @Override
    public Optional<Long> mapToNavPlatId(Long providerId, String providerUserId) {
        return ofNullable(mappings.get(key(providerId, providerUserId)));
    }

    @Override
    public void addMapping(Long providerId, String providerUserId, Long navPlatPostId) {
        mappings.put(key(providerId, providerUserId), navPlatPostId);
    }

    private String key(Long providerId, String providerUserId) {
        return providerId + "" + providerUserId;
    }

    @Override
    public Optional<PostProviderUser> get(Long providerId, String user) {
        throw new UnsupportedOperationException();
    }

}
