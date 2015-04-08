package com.navent.integrations.igi.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.navent.integrations.igi.ws.security.PostProviderGroup;

public interface PostProviderGroupRepository extends CrudRepository<PostProviderGroup, Long> {

    public Optional<PostProviderGroup> findById(Long id);

}
