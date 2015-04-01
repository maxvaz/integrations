package com.navent.integrations.igi.model;

import static java.util.Optional.ofNullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryProviderUserRepository implements ProviderUserRepository {

    private final Map<String, Long> mappings;

    public InMemoryProviderUserRepository() {
        mappings = new HashMap<String, Long>();
        mappings.put(key(8L, "5874251"), 99999L);
    }

    @Override
    public Optional<Long> mapToNavPlatId(Long providerId, String providerUserId) {
        return ofNullable(mappings.get(key(providerId, providerUserId)));
    }

    private String key(Long providerId, String providerUserId) {
        return providerId + "" + providerUserId;
    }

}
