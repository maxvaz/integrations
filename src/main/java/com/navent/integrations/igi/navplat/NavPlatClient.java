package com.navent.integrations.igi.navplat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.dridco.inmuebles.ws.g7.model.Aviso;
import com.dridco.inmuebles.zz.BusinessDomain;
import com.dridco.inmuebles.zz.EditFullProjectPostOperation;
import com.dridco.inmuebles.zz.ModifyPostBusinessCommand;
import com.dridco.inmuebles.zz.NewFullProjectPostOperation;
import com.dridco.inmuebles.zz.PostContactDisplayable;

public interface NavPlatClient {

    Long post(String usuario, Long proveedor, Aviso aviso);

    // /post/${id}

    // validar que corresponda al user???
    // respuestas validas:
    // - 404
    // - 2xx
    Optional<NavPlatPost> get(Long postId, Long userId);

    List<PostContactDisplayable> getContacts(Long valueOf, Long adId, Date fromDate, Date toDate);

    NavPlatPost getPostByIdAndProviderId(Long postId, Long providerId);

    boolean isBuildingProject(Long postId);

    Long postProject(NewFullProjectPostOperation projectOperation);

    void updateProject(EditFullProjectPostOperation operation);

    // finishPostBusinessCommand.setSendFinishPostNotification(Boolean.TRUE);
    // finishPostBusinessCommand.setIsExternalFinished(Boolean.TRUE);
    // finishPostBusinessCommand.setPostProviderId(provider);
    // finishPostBusinessCommand.setChangeProviderNewsToNotProcessable(changeProviderNewsToNotProcessable);
    void finishPost(Long postId, Boolean changeProviderNewsToNotProcessable);

    boolean checkIfProviderOwnedAPost(Long provider, Long adId);

    NavPlatUser getUser(Long zpUserId);

    List<NavPlatLocation> getLocations(BusinessDomain businessDomain);

    void updatePost(ModifyPostBusinessCommand command);

}
