package com.navent.integrations.igi.ws;

import static java.lang.Long.valueOf;
import static org.springframework.util.Assert.hasText;

import java.util.List;
import java.util.Optional;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dridco.inmuebles.ws.g7.model.Aviso;
import com.dridco.inmuebles.ws.g7.model.ConsultarPublicacionResponse;
import com.dridco.inmuebles.ws.g7.model.GetLocationProjectTypesResponse;
import com.dridco.inmuebles.ws.g7.model.GetPostContactsResponse;
import com.dridco.inmuebles.ws.g7.model.GetPublishedRealEstatesResponse;
import com.dridco.inmuebles.ws.g7.model.GetRealEstateContactsRequest;
import com.dridco.inmuebles.ws.g7.model.IgiProjectPost;
import com.dridco.inmuebles.ws.g7.model.WebServiceIntegerResponse;
import com.dridco.inmuebles.ws.g7.model.WebServiceResponse;
import com.dridco.inmuebles.ws.g7.model.Zona;
import com.dridco.inmuebles.ws.g7.service.RealEstateService;
import com.navent.integrations.igi.model.repository.PostMappingRepository;
import com.navent.integrations.igi.model.repository.ProviderUserRepository;
import com.navent.integrations.igi.navplat.NavPlatClient;
import com.navent.integrations.igi.navplat.NavPlatPost;
import com.navent.integrations.igi.navplat.adapters.AvisoAdapter;

@WebService(endpointInterface = "com.dridco.inmuebles.ws.g7.service.RealEstateService", serviceName = "RealStateService")
@Service("realEstateServiceImpl")
public class RealEstateServiceImpl implements RealEstateService {

    private final AvisoAdapter avisoAdapter;
    private final NavPlatClient navPlatClient;
    private final PostMappingRepository postMappingRepository;
    private final ProviderUserRepository providerUserRepository;

    @Autowired
    public RealEstateServiceImpl(NavPlatClient navPlatClient, AvisoAdapter avisoAdapter,
            PostMappingRepository postMappingRepository, ProviderUserRepository providerUserRepository) {
        this.navPlatClient = navPlatClient;
        this.avisoAdapter = avisoAdapter;
        this.postMappingRepository = postMappingRepository;
        this.providerUserRepository = providerUserRepository;
    }

    @Override
    public Aviso consultarAviso(String providerUserId, Long providerId, String unused2, String providerPostId) {
        hasText(providerUserId);
        hasText(providerPostId);

        Long navPlatUserId = providerUserRepository.mapToNavPlatId(providerId, providerUserId).orElseThrow(
                IllegalStateException::new);

        Long navPlatPostId = postMappingRepository.mapToNavPlatId(providerId, providerUserId, providerPostId).orElse(
                valueOf(providerPostId));

        Optional<NavPlatPost> navPlatPost = navPlatClient.get(navPlatPostId, navPlatUserId);

        return this.avisoAdapter.adapt(navPlatPost);
    }

    @Override
    public ConsultarPublicacionResponse consultarPublicaciones(String usuario, Long proveedor, String password) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> consultarTiposInmueblesPorUbicacion(String usuario, Long proveedor, String password,
            String pais, Integer idUbicacion) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Zona> consultarUbicaciones(String usuario, Long proveedor, String password, String pais) {
        throw new UnsupportedOperationException();
    }

    @Override
    public WebServiceResponse endRealEstatePost(String user, Long provider, String password, String externalId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public WebServiceResponse finalizar(String usuario, Long proveedor, String password, String providerId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public WebServiceResponse finalizarAviso(String usuario, Long proveedor, String password, Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public WebServiceResponse finalizarInternal(String usuario, Long proveedor, String password, String avisoProveedorId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public GetLocationProjectTypesResponse getLocationProjectTypes(String user, Long provider, String password,
            String country, Long locationId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public GetPublishedRealEstatesResponse getPublishedRealEstates(String user, Long provider, String password) {
        throw new UnsupportedOperationException();
    }

    @Override
    public GetPostContactsResponse getRealEstateContacts(String user, Long provider, String password,
            GetRealEstateContactsRequest getRealEstateContactsRequest) {
        throw new UnsupportedOperationException();
    }

    @Override
    public WebServiceResponse modificarAviso(String usuario, Long proveedor, String password, Aviso aviso) {
        throw new UnsupportedOperationException();
    }

    @Override
    public WebServiceResponse publicar(String usuario, Long proveedor, String password, Boolean dryRun, Aviso aviso) {
        throw new UnsupportedOperationException();
    }

    @Override
    public WebServiceIntegerResponse publicarAviso(String usuario, Long proveedor, String password, Aviso aviso) {
        throw new UnsupportedOperationException();
    }

    @Override
    public WebServiceResponse publicarInternal(String usuario, Long proveedor, String password, Boolean dryRun,
            Aviso aviso) {
        throw new UnsupportedOperationException();
    }

    @Override
    public WebServiceResponse publishProject(String providerUserId, Long providerId, String password,
            IgiProjectPost igiProjectPost) {
        throw new UnsupportedOperationException();
    }

}
