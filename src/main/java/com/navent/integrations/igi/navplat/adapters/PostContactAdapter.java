package com.navent.integrations.igi.navplat.adapters;

import org.springframework.stereotype.Component;

import com.dridco.inmuebles.ws.g7.model.IgiPostContact;
import com.dridco.inmuebles.zz.PostContactDisplayable;
import com.dridco.inmuebles.zz.ProviderNews;

@Component
public class PostContactAdapter {

    public IgiPostContact adapt(PostContactDisplayable basePostContact, ProviderNews providerNews) {
        throw new UnsupportedOperationException();
    }

}
