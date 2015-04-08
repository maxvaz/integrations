package com.navent.integrations.igi.navplat.adapters;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.dridco.inmuebles.ws.g7.model.Aviso;
import com.dridco.inmuebles.ws.g7.model.Especificacion;
import com.navent.integrations.igi.navplat.NavPlatPost;

@Component
public class AvisoAdapter {

    private static final Aviso AVISO_NOT_FOUND = null;

    public Aviso adapt(Optional<NavPlatPost> optionalNavPlatPost) {
        if (!optionalNavPlatPost.isPresent()) {
            return AVISO_NOT_FOUND;
        }

        NavPlatPost navPlatPost = optionalNavPlatPost.get();

        Aviso aviso = new Aviso();
        // aviso.setIdAviso(navPlatPost.getId());
        aviso.setSubtitulo(navPlatPost.getSubtitle());
        aviso.setTipoPropiedad(navPlatPost.getRealEstateType());
        aviso.setTipoOperacion(navPlatPost.getOperationType());
        aviso.setTipoMoneda(navPlatPost.getCurrency());
        aviso.setPrecio(navPlatPost.getPrice());
        aviso.setDescripcion(navPlatPost.getDescription());
        aviso.setUbicacion(navPlatPost.getLocation());
        aviso.setContacto(navPlatPost.getContact());
        aviso.setUrlImagenes(navPlatPost.getImageUrls());
        aviso.setEspecificaciones(mapItemSpecifics(navPlatPost));
        aviso.setMedidas(navPlatPost.getMeasures());

        return aviso;
    }

    private List<Especificacion> mapItemSpecifics(NavPlatPost navPlatPost) {
        return new ArrayList<Especificacion>();
    }

    public NavPlatPost adapt(Aviso aviso) {
        return new NavPlatPost();
    }
}
