package com.navent.integrations.igi.model.repository;

import static java.util.Optional.ofNullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.navent.integrations.igi.ws.security.PostProvider;

@Repository
public class InMemoryPostProviderRepository implements PostProviderRepository {

    private final Map<Long, PostProvider> postProviders;

    public InMemoryPostProviderRepository() {
        postProviders = new HashMap<Long, PostProvider>();
    }

    @Override
    public Optional<PostProvider> get(Long providerId) {
        // boolean providerAllowed = provider.getCategory().equals(EXTERNAL);
        // if (!providerAllowed) {
        // throw new RuntimeException("Provider " + provider.getId() + " is not allowed to use this interface.");
        // }

        return ofNullable(postProviders.get(providerId));
    }

}
