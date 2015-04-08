package com.navent.integrations.igi.navplat;

import java.util.Optional;

public interface NavPlatClient {

    // GET /post/{id}

    // validar que corresponda al user???
    // respuestas validas:
    // - 404
    // - 2xx
    Optional<NavPlatPost> get(Long postId, Long userId);

    // DELETE /post/{postId}
    void delete(Long postId);

    // PUT /post/{postId}
    void update(Long postId, NavPlatPost navPlatPost);

    // POST /post?dryRun={dryRun}
    Long post(NavPlatPost navPlatPost, Boolean dryRun);

}
