package com.navent.integrations.igi.model;

import static java.util.Arrays.asList;
import static java.util.Optional.ofNullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryPostMappingRepository implements PostMappingRepository {

    private final Map<Object[], Long> mappingsByPost;
    private final Map<Object[], List<PostMapping>> mappingsByUser;

    public InMemoryPostMappingRepository() {
        mappingsByPost = new HashMap<Object[], Long>();
        mappingsByUser = new HashMap<Object[], List<PostMapping>>();
    }

    @Override
    public void addMapping(Long providerId, String providerUserId, String providerPostId, Long navPlatPostId) {
        mappingsByPost.put(key(providerId, providerUserId, providerPostId), navPlatPostId);

        List<PostMapping> mappings = mappingsByUser.getOrDefault(key(providerId, providerUserId), asList());
        mappings.add(new PostMapping(Long.valueOf(providerPostId), navPlatPostId));
    }

    @Override
    public Iterable<PostMapping> getAllMappings(Long providerId, String providerUserId) {
        return mappingsByUser.get(key(providerId, providerUserId));
    }

    @Override
    public Optional<Long> mapToNavPlatId(Long providerId, String providerUserId, String postId) {
        return ofNullable(mappingsByPost.get(key(providerId, providerUserId, postId)));
    }

    private Object[] key(Object... entries) {
        return entries;
    }

}
