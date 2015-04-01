package com.navent.integrations.igi.navplat;

import static java.util.Optional.ofNullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class InMemoryNavPlatClient implements NavPlatClient {

    private final Map<Long, NavPlatPost> posts;

    public InMemoryNavPlatClient() {
        posts = new HashMap<Long, NavPlatPost>();
    }

    @Override
    public Optional<NavPlatPost> get(Long postId, Long userId) {
        return ofNullable(posts.get(postId));
    }

}
