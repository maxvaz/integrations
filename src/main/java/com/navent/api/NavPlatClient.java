package com.navent.api;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dridco.inmuebles.ws.g7.model.Aviso;
import com.dridco.inmuebles.zz.BusinessDomain;
import com.dridco.inmuebles.zz.EditFullProjectPostOperation;
import com.dridco.inmuebles.zz.ModifyPostBusinessCommand;
import com.dridco.inmuebles.zz.NewFullProjectPostOperation;
import com.dridco.inmuebles.zz.PostContactDisplayable;

@Component
public class NavPlatClient {

    public Long post(String usuario, Long proveedor, Aviso aviso) {
        throw new UnsupportedOperationException();
    }

    public NavPlatPost get(Long postId) {
        throw new UnsupportedOperationException();
    }

    public List<PostContactDisplayable> getContacts(Long valueOf, Long adId, Date fromDate, Date toDate) {
        throw new UnsupportedOperationException();
    }

    public NavPlatPost getPostByIdAndProviderId(Long postId, Long providerId) {
        throw new UnsupportedOperationException();
    }

    public boolean isBuildingProject(Long postId) {
        throw new UnsupportedOperationException();
    }

    public Long postProject(NewFullProjectPostOperation projectOperation) {
        throw new UnsupportedOperationException();
    }

    public void updateProject(EditFullProjectPostOperation operation) {
        throw new UnsupportedOperationException();
    }

    public void finishPost(Long postId, Boolean changeProviderNewsToNotProcessable) {
        throw new UnsupportedOperationException();
        // finishPostBusinessCommand.setSendFinishPostNotification(Boolean.TRUE);
        // finishPostBusinessCommand.setIsExternalFinished(Boolean.TRUE);
        // finishPostBusinessCommand.setPostProviderId(provider);
        // finishPostBusinessCommand.setChangeProviderNewsToNotProcessable(changeProviderNewsToNotProcessable);

    }

    public boolean checkIfProviderOwnedAPost(Long provider, Long adId) {
        throw new UnsupportedOperationException();
    }

    public NavPlatUser getUser(Long zpUserId) {
        throw new UnsupportedOperationException();
    }

    public List<NavPlatLocation> getLocations(BusinessDomain businessDomain) {
        throw new UnsupportedOperationException();
    }

    public void updatePost(ModifyPostBusinessCommand command) {
        throw new UnsupportedOperationException();
    }

}
