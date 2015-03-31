package com.navent.integrations.igi.navplat.adapters;

import org.springframework.stereotype.Component;

import com.dridco.inmuebles.ws.g7.model.Aviso;
import com.dridco.inmuebles.zz.BusinessDomain;
import com.dridco.inmuebles.zz.ModifyPostBusinessCommand;
import com.dridco.inmuebles.zz.NewPostBusinessCommand;

/**
 * @author Matias Fernandez (mfernandez@dridco.com)
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 * @author jdifranco@dridco.com (Jonathan Di Franco)
 * @author rrodriguez@dridco.com
 */
@Component
public class PostAdapter {

    public ModifyPostBusinessCommand adaptToModifyPostCommand(Aviso aviso, BusinessDomain businessDomain, Long userId,
            Long providerId) {
        throw new UnsupportedOperationException();
    }

    public NewPostBusinessCommand adaptToNewPostCommand(Aviso aviso, BusinessDomain businessDomain, Long userId,
            Long providerId) {
        throw new UnsupportedOperationException();
    }
}
