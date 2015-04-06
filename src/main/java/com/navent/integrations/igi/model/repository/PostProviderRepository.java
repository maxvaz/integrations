package com.navent.integrations.igi.model.repository;

import java.util.Optional;

import com.navent.integrations.igi.ws.security.PostProviderGroup;

public interface PostProviderRepository {

    public Optional<PostProviderGroup> get(Long providerId);

}
