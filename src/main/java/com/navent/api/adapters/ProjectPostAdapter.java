package com.navent.api.adapters;

import org.springframework.stereotype.Component;

import com.dridco.inmuebles.ws.g7.model.IgiProjectPost;
import com.dridco.inmuebles.zz.EditFullProjectPostOperation;
import com.dridco.inmuebles.zz.NewFullProjectPostOperation;
import com.navent.api.NavPlatPost;
import com.navent.api.NavPlatUser;

/**
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
@Component
public class ProjectPostAdapter {

    public NewFullProjectPostOperation adaptToNewProjectOperation(IgiProjectPost igiProjectPost, NavPlatUser user,
            Long providerId) {
        throw new UnsupportedOperationException();
    }

    public EditFullProjectPostOperation adaptToEditProjectOperation(IgiProjectPost igiProjectPost, NavPlatPost post) {
        throw new UnsupportedOperationException();
    }

}
