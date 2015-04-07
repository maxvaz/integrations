package com.navent.integrations.igi.ws;

import static com.dridco.inmuebles.ws.g7.model.WebServiceResponse.ok;
import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

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
import com.dridco.inmuebles.ws.g7.model.PublicationPair;
import com.dridco.inmuebles.ws.g7.model.WebServiceIntegerResponse;
import com.dridco.inmuebles.ws.g7.model.WebServiceResponse;
import com.dridco.inmuebles.ws.g7.model.Zona;
import com.dridco.inmuebles.ws.g7.service.RealEstateService;
import com.navent.integrations.igi.model.repository.PostMapping;
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

        Long navPlatUserId = providerUserRepository.mapToNavPlatId(providerId, providerUserId).orElseThrow(
                IllegalStateException::new);

        Long navPlatPostId = postMappingRepository.mapToNavPlatId(providerId, providerUserId, providerPostId).orElse(
                Long.valueOf(providerPostId));

        Optional<NavPlatPost> navPlatPost = navPlatClient.get(navPlatPostId, navPlatUserId);

        return this.avisoAdapter.adapt(navPlatPost);
    }

    @Override
    public ConsultarPublicacionResponse consultarPublicaciones(String providerUserId, Long providerId, String password) {
        Iterable<PostMapping> postMapping = postMappingRepository.getAllMappings(providerId, providerUserId);
        List<PublicationPair> pairs = stream(postMapping.spliterator(), false).map(toPublicationPair()).collect(
                toList());
        return new ConsultarPublicacionResponse(pairs);
    }

    @Override
    public List<String> consultarTiposInmueblesPorUbicacion(String providerUserId, Long providerId, String password,
            String country, Integer locationId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Zona> consultarUbicaciones(String providerUserId, Long providerId, String password, String country) {
        throw new UnsupportedOperationException();
    }

    @Override
    public WebServiceResponse endRealEstatePost(String providerUserId, Long providerId, String password,
            String providerPostId) {
        Long navPlatPostId = postMappingRepository.mapToNavPlatId(providerId, providerUserId, providerPostId).orElse(
                Long.valueOf(providerPostId));
        navPlatClient.delete(navPlatPostId);
        return ok();
    }

    @Override
    public WebServiceResponse finalizar(String providerUserId, Long providerId, String password, String providerPostId) {
        return endRealEstatePost(providerUserId, providerId, password, providerPostId);
    }

    @Override
    public WebServiceResponse finalizarAviso(String providerUserId, Long providerId, String password,
            Integer providerPostId) {
        return endRealEstatePost(providerUserId, providerId, password, providerPostId.toString());
    }

    @Override
    public GetLocationProjectTypesResponse getLocationProjectTypes(String providerUserId, Long providerId,
            String password, String country, Long locationId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public GetPublishedRealEstatesResponse getPublishedRealEstates(String providerUserId, Long providerId,
            String password) {
        throw new UnsupportedOperationException();
    }

    @Override
    public GetPostContactsResponse getRealEstateContacts(String providerUserId, Long providerId, String password,
            GetRealEstateContactsRequest getRealEstateContactsRequest) {
        throw new UnsupportedOperationException();
    }

    @Override
    public WebServiceResponse modificarAviso(String providerUserId, Long providerId, String password, Aviso aviso) {
        throw new UnsupportedOperationException();
    }

    @Override
    public WebServiceResponse publicar(String providerUserId, Long providerId, String password, Boolean dryRun,
            Aviso aviso) {
        throw new UnsupportedOperationException();
    }

    @Override
    public WebServiceIntegerResponse publicarAviso(String providerUserId, Long providerId, String password, Aviso aviso) {
        throw new UnsupportedOperationException();
    }

    @Override
    public WebServiceResponse publishProject(String providerUserId, Long providerId, String password,
            IgiProjectPost igiProjectPost) {
        throw new UnsupportedOperationException();
    }

    private Function<PostMapping, PublicationPair> toPublicationPair() {
        return (postMapping) -> new PublicationPair(postMapping.getNavPlatId().toString(), postMapping
                .getProviderPostId().toString());
    }

}
