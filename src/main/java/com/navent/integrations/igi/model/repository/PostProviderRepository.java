package com.navent.integrations.igi.model.repository;

import java.util.Optional;

import com.navent.integrations.igi.ws.security.PostProvider;

public interface PostProviderRepository {

    public Optional<PostProvider> get(Long providerId);

}
