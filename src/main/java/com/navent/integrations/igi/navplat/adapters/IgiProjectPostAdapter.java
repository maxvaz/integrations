package com.navent.integrations.igi.navplat.adapters;

import org.springframework.stereotype.Component;

import com.dridco.inmuebles.ws.g7.model.IgiProjectPost;
import com.navent.integrations.igi.navplat.NavPlatPost;

@Component
public class IgiProjectPostAdapter {

    public NavPlatPost adapt(IgiProjectPost igiProjectPost) {
        return new NavPlatPost();
    }

}
