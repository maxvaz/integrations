package com.navent.integrations.igi.model;

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
        mappings.put(key("999999", 8L), 99999L);
    }

    private String key(String postId, Long providerId) {
        return postId + "" + providerId;
    }

    @Override
    public Optional<Long> mapToNavPlatId(String postId, Long providerId) {
        return ofNullable(mappings.get(key(postId, providerId)));
    }

}
