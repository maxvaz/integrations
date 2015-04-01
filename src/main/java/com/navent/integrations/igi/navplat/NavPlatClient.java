package com.navent.integrations.igi.navplat;

import java.util.Optional;

public interface NavPlatClient {

    // GET /post/${id}

    // validar que corresponda al user???
    // respuestas validas:
    // - 404
    // - 2xx
    Optional<NavPlatPost> get(Long postId, Long userId);

}
