package com.navent.integrations.igi.navplat.adapters;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.dridco.inmuebles.ws.g7.model.Aviso;
import com.navent.integrations.igi.navplat.NavPlatPost;

/**
 * @author pfenoglio
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
@Component
public class AvisoAdapter {

    private static final Aviso AVISO_NOT_FOUND = null;

    public Aviso adapt(Optional<NavPlatPost> navPlatPost) {
        if (!navPlatPost.isPresent()) {
            return AVISO_NOT_FOUND;
        }
        throw new UnsupportedOperationException();
    }

}
