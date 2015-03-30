package com.navent.api.adapters;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dridco.inmuebles.ws.g7.model.Aviso;
import com.dridco.inmuebles.ws.g7.model.IgiProjectPost;
import com.dridco.inmuebles.zz.ProviderNews;
import com.dridco.inmuebles.zz.PublicationDTO;

@Component
public class NewsAdapter {

    public ProviderNews getImportedProviderNews(String idAvisoProveedor, Long proveedor) {
        throw new UnsupportedOperationException();
    }

    public void adaptPostProviderNews(Aviso aviso, Long proveedor, boolean b) {
        throw new UnsupportedOperationException();
    }

    public ProviderNews getPostIdByPostProviderNewsId(String trim) {
        throw new UnsupportedOperationException();
    }

    public List<PublicationDTO> getAllNewsByUserIdAndProviderId(int parseInt, Long proveedor) {
        throw new UnsupportedOperationException();
    }

    public ProviderNews getPostIdByPostId(int id) {
        throw new UnsupportedOperationException();
    }

    public void adaptPostProviderNews(IgiProjectPost igiProjectPost, Long providerId, boolean b) {
        throw new UnsupportedOperationException();
    }

}
