package com.navent.integrations.igi.navplat;

import static java.util.Optional.ofNullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

@Component
public class InMemoryNavPlatClient implements NavPlatClient {

    private final Map<Long, NavPlatPost> posts;
    private final AtomicLong nextId = new AtomicLong();

    public InMemoryNavPlatClient() {
        posts = new HashMap<Long, NavPlatPost>();
    }

    @Override
    public Optional<NavPlatPost> get(Long postId, Long userId) {
        return ofNullable(posts.get(postId));
    }

    @Override
    public void delete(Long postId) {
        posts.remove(postId);
    }

    @Override
    public void update(Long navPlatPostId, NavPlatPost navPlatPost) {
        posts.put(navPlatPostId, navPlatPost);
    }

    @Override
    public Long post(NavPlatPost navPlatPost, Boolean dryRun) {
        if (dryRun) {
            throw new UnsupportedOperationException();
        }

        long id = nextId.incrementAndGet();
        posts.put(id, navPlatPost);
        return id;
    }
}
