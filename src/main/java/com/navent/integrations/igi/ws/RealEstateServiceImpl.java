package com.navent.integrations.igi.ws;

import static com.dridco.inmuebles.ws.g7.model.ServiceReturnCode.INVALID_OWNER_USER_ERROR;
import static com.dridco.inmuebles.ws.g7.model.ServiceReturnCode.INVALID_POST_OPERATION_ERROR;
import static com.dridco.inmuebles.ws.g7.model.ServiceReturnCode.MESSAGE_FORMAT_ERROR;
import static com.dridco.inmuebles.ws.g7.model.ServiceReturnCode.SUCCESS;
import static com.dridco.inmuebles.ws.g7.model.ServiceReturnCode.UNKNOWN_ERROR;
import static com.dridco.inmuebles.ws.g7.model.ServiceReturnCode.UNKNOWN_POST_ID_ERROR;
import static com.dridco.inmuebles.ws.g7.model.ServiceReturnCode.UNKNOWN_POST_PROVIDER_ERROR;
import static java.lang.Boolean.FALSE;
import static java.lang.Long.valueOf;
import static org.springframework.util.Assert.hasText;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.jws.WebService;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dridco.inmuebles.ws.g7.exception.InvalidOwnerUserException;
import com.dridco.inmuebles.ws.g7.exception.InvalidPostOperationException;
import com.dridco.inmuebles.ws.g7.exception.UnknownPostIdException;
import com.dridco.inmuebles.ws.g7.exception.UnknownUserException;
import com.dridco.inmuebles.ws.g7.model.Aviso;
import com.dridco.inmuebles.ws.g7.model.ConsultarPublicacionResponse;
import com.dridco.inmuebles.ws.g7.model.GetLocationProjectTypesResponse;
import com.dridco.inmuebles.ws.g7.model.GetPostContactsResponse;
import com.dridco.inmuebles.ws.g7.model.GetPublishedRealEstatesResponse;
import com.dridco.inmuebles.ws.g7.model.GetRealEstateContactsRequest;
import com.dridco.inmuebles.ws.g7.model.IgiPostContact;
import com.dridco.inmuebles.ws.g7.model.IgiProjectPost;
import com.dridco.inmuebles.ws.g7.model.IgiProjectUnit;
import com.dridco.inmuebles.ws.g7.model.IgiRealEstatePost;
import com.dridco.inmuebles.ws.g7.model.PublicationPair;
import com.dridco.inmuebles.ws.g7.model.ServiceReturnCode;
import com.dridco.inmuebles.ws.g7.model.WebServiceIntegerResponse;
import com.dridco.inmuebles.ws.g7.model.WebServiceResponse;
import com.dridco.inmuebles.ws.g7.model.Zona;
import com.dridco.inmuebles.ws.g7.service.RealEstateService;
import com.dridco.inmuebles.zz.BusinessDomain;
import com.dridco.inmuebles.zz.EditFullProjectPostOperation;
import com.dridco.inmuebles.zz.ModifyPostBusinessCommand;
import com.dridco.inmuebles.zz.NewFullProjectPostOperation;
import com.dridco.inmuebles.zz.PostContactDisplayable;
import com.dridco.inmuebles.zz.ProviderNews;
import com.dridco.inmuebles.zz.PublicationDTO;
import com.dridco.inmuebles.zz.RealEstateTypeEnum;
import com.dridco.inmuebles.zz.SimpleErrors;
import com.navent.integrations.igi.model.PostMappingRepository;
import com.navent.integrations.igi.model.ProviderUserRepository;
import com.navent.integrations.igi.navplat.NavPlatClient;
import com.navent.integrations.igi.navplat.NavPlatPost;
import com.navent.integrations.igi.navplat.NavPlatUser;
import com.navent.integrations.igi.navplat.adapters.AdaptSpecifications;
import com.navent.integrations.igi.navplat.adapters.AvisoAdapter;
import com.navent.integrations.igi.navplat.adapters.LocationAdapter;
import com.navent.integrations.igi.navplat.adapters.NewsAdapter;
import com.navent.integrations.igi.navplat.adapters.PostAdapter;
import com.navent.integrations.igi.navplat.adapters.PostContactAdapter;
import com.navent.integrations.igi.navplat.adapters.ProjectPostAdapter;

/**
 * @author aobara
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 * @author Matias Fernandez (mfernandez@dridco.com)
 */
@WebService(endpointInterface = "com.dridco.inmuebles.ws.g7.service.RealEstateService", serviceName = "RealStateService")
@Service("realEstateServiceImpl")
public class RealEstateServiceImpl implements RealEstateService {

    private static final Logger LOG = Logger.getLogger(RealEstateServiceImpl.class);

    private final AvisoAdapter avisoAdapter;
    private final Validator avisoValidator;
    private final Validator igiPostProviderValidator;
    private final Validator igiProjectPostValidator;
    private final LocationAdapter locationAdapter;
    private final NavPlatClient navPlatClient;
    private final NewsAdapter newsAdapter;
    private final PostAdapter postAdapter;
    private final PostContactAdapter postContactAdapter;
    private final PostSubtitlePreProcessor postSubtitlePreProcessor;
    private final ProjectPostAdapter projectPostAdapter;
    private final ProviderUserValidationService providerUserValidationService;
    private final ResponseBuilder responseBuilder;
    private final AdaptSpecifications specificationsAdapter;
    private final PostMappingRepository postMappingRepository;
    private final ProviderUserRepository providerUserRepository;

    @Autowired
    public RealEstateServiceImpl(ResponseBuilder responseBuilder, Validator avisoValidator,
            Validator igiProjectPostValidator, Validator igiPostProviderValidator,
            ProviderUserValidationService providerUserValidationService,
            PostSubtitlePreProcessor postSubtitlePreProcessor, AdaptSpecifications specificationsAdapter,
            NewsAdapter newsAdapter, LocationAdapter locationAdapter, NavPlatClient navPlatClient,
            AvisoAdapter avisoAdapter, ProjectPostAdapter projectPostAdapter, PostContactAdapter postContactAdapter,
            PostAdapter postAdapter, PostMappingRepository postMappingRepository,
            ProviderUserRepository providerUserRepository) {
        this.responseBuilder = responseBuilder;
        this.avisoValidator = avisoValidator;
        this.igiProjectPostValidator = igiProjectPostValidator;
        this.igiPostProviderValidator = igiPostProviderValidator;
        this.providerUserValidationService = providerUserValidationService;
        this.postSubtitlePreProcessor = postSubtitlePreProcessor;
        this.specificationsAdapter = specificationsAdapter;
        this.newsAdapter = newsAdapter;
        this.locationAdapter = locationAdapter;
        this.navPlatClient = navPlatClient;
        this.avisoAdapter = avisoAdapter;
        this.projectPostAdapter = projectPostAdapter;
        this.postContactAdapter = postContactAdapter;
        this.postAdapter = postAdapter;
        this.postMappingRepository = postMappingRepository;
        this.providerUserRepository = providerUserRepository;
    }

    @Override
    public Aviso consultarAviso(String providerUserId, Long providerId, String unused2, String providerPostId) {
        hasText(providerUserId);
        hasText(providerPostId);

        Long navPlatUserId = providerUserRepository.mapToNavPlatId(providerId, providerUserId).orElseThrow(
                IllegalStateException::new);

        Long navPlatPostId = postMappingRepository.mapToNavPlatId(providerPostId, providerId).orElse(
                valueOf(providerPostId));

        Optional<NavPlatPost> navPlatPost = navPlatClient.get(navPlatPostId, navPlatUserId);

        return this.avisoAdapter.adapt(navPlatPost);
    }

    @Override
    public ConsultarPublicacionResponse consultarPublicaciones(String usuario, Long proveedor, String password) {
        try {
            List<PublicationDTO> pubsDTO = this.newsAdapter.getAllNewsByUserIdAndProviderId(Integer.parseInt(usuario),
                    proveedor);
            List<PublicationPair> pubs = new ArrayList<>();
            ConsultarPublicacionResponse response = new ConsultarPublicacionResponse();

            PublicationPair onePub = null;
            if (!CollectionUtils.isEmpty(pubsDTO)) {
                for (PublicationDTO dto : pubsDTO) {
                    onePub = new PublicationPair();
                    onePub.setIdAvisoZonaProp(dto.getIdZP().toString());
                    onePub.setIdEntidadIgi(dto.getIdIGI());
                    pubs.add(onePub);
                }
            }
            response.setPublicaciones(pubs);
            return response;
        } catch (Exception e) {
            LOG.error("Error consultando publicaciones id proveedor: " + proveedor, e);
            return null;
        }
    }

    @Override
    public List<String> consultarTiposInmueblesPorUbicacion(String usuario, Long proveedor, String password,
            String pais, Integer idUbicacion) {
        return this.locationAdapter.getUnitConcepts(Long.valueOf(idUbicacion), new BusinessDomain(pais));
    }

    @Override
    public List<Zona> consultarUbicaciones(String usuario, Long proveedor, String password, String pais) {
        return this.locationAdapter.adapt(this.navPlatClient.getLocations(new BusinessDomain(pais)));
    }

    @Override
    public WebServiceResponse endRealEstatePost(String user, Long provider, String password, String externalId) {
        return this.finalizar(user, provider, password, externalId);
    }

    @Override
    public WebServiceResponse finalizar(String usuario, Long proveedor, String password, String providerId) {
        ProviderNews providerNews = this.newsAdapter.getImportedProviderNews(providerId, proveedor);

        if (providerNews == null) {
            LOG.warn("Error finalizando publicación id aviso: " + providerId + " - idusuario: " + usuario);
            return this.responseBuilder.buildResponse(UNKNOWN_POST_PROVIDER_ERROR);
        }

        Long postId = providerNews.getPostId();

        return this.finishPost(proveedor, postId.intValue(), Boolean.TRUE);
    }

    @Override
    public WebServiceResponse finalizarAviso(String usuario, Long proveedor, String password, Integer id) {
        return this.finishPost(proveedor, id, Boolean.FALSE);
    }

    @Override
    public WebServiceResponse finalizarInternal(String usuario, Long proveedor, String password, String avisoProveedorId) {
        return this.finalizar(usuario, proveedor, password, avisoProveedorId);
    }

    @Override
    public GetLocationProjectTypesResponse getLocationProjectTypes(String user, Long provider, String password,
            String country, Long locationId) {
        return new GetLocationProjectTypesResponse(this.locationAdapter.getProjectConcepts(locationId,
                new BusinessDomain(country)));
    }

    @Override
    public GetPublishedRealEstatesResponse getPublishedRealEstates(String user, Long provider, String password) {
        ConsultarPublicacionResponse publicacionResponse = consultarPublicaciones(user, provider, password);
        return publicacionResponse == null ? null : new GetPublishedRealEstatesResponse(publicacionResponse);
    }

    /**
     * Metodo que trae los Contactos de las publicaciones de un usuario. Se debe enviar el Id del Usuario y en caso de
     * desear un aviso en particular, el Id de ese aviso, caso contrario trae todos los comentarios de todas sus
     * publicaciones. A su vez, tambien permite filtrar por las fechas desde y hasta del comentario.
     *
     */
    @Override
    public GetPostContactsResponse getRealEstateContacts(String user, Long provider, String password,
            GetRealEstateContactsRequest getRealEstateContactsRequest) {

        GetPostContactsResponse response = new GetPostContactsResponse();

        try {
            Date toDate = getRealEstateContactsRequest.getNormalizedToDate();
            Date fromDate = getRealEstateContactsRequest.getNormalizedFromDate();
            Long adId = this.createValidAdIdFromString(getRealEstateContactsRequest.getAdId());
            this.validatePost(adId, Long.valueOf(user));

            List<PostContactDisplayable> postContacts = this.navPlatClient.getContacts(Long.valueOf(user), adId,
                    fromDate, toDate);

            for (PostContactDisplayable postContact : postContacts) {
                ProviderNews providerNews = this.newsAdapter.getPostIdByPostId(postContact.getPost().getId());
                IgiPostContact igiPostContact = postContactAdapter.adapt(postContact, providerNews);
                response.getIgiPostContacts().add(igiPostContact);
            }
        } catch (NumberFormatException e) {
            LOG.warn("Error retrieving Contacts from provider : " + provider + " and user : " + user, e);
            response.setErrorDescription(e.getMessage());
            return response;
        } catch (UnknownUserException e) {
            LOG.warn("Error retrieving Contacts from provider : " + provider + " and user : " + user, e);
            response.setErrorDescription("Invalid Post");
            return response;
        } catch (Exception e) {
            LOG.warn("Error retrieving Contacts from provider : " + provider + " and user : " + user, e);
            response.setErrorDescription(e.getMessage());
            return response;
        }

        return response;
    }

    @Override
    public WebServiceResponse modificarAviso(String usuario, Long proveedor, String password, Aviso aviso) {
        try {
            aviso.setPais(new BusinessDomain(aviso.getPais()).getCountryCode());

            preProcessAviso(aviso, proveedor);

            Errors errors = this.validateAviso(aviso, proveedor);

            if (errors.getErrorCount() > 0) {
                logValidationErrors(aviso, errors);
                return this.responseBuilder.buildResponse(MESSAGE_FORMAT_ERROR, errors);
            }

            modifyZpPost(usuario, proveedor, aviso);

            WebServiceResponse response = this.responseBuilder.buildResponse(SUCCESS);
            return response;
        } catch (UnknownPostIdException e) {
            LOG.warn("Error modificando publicación id aviso: " + aviso.getIdAviso() + " - " + e.getMessage());
            return this.responseBuilder.buildResponse(UNKNOWN_POST_ID_ERROR, e);
        } catch (InvalidPostOperationException e) {
            LOG.warn("Error modificando publicación id aviso: " + aviso.getIdAviso() + " - " + e.getMessage());
            return this.responseBuilder.buildResponse(INVALID_POST_OPERATION_ERROR, e);
        } catch (InvalidOwnerUserException e) {
            LOG.warn("Error modificando publicación id aviso: " + aviso.getIdAviso() + " - " + e.getMessage()
                    + " idusuario: " + usuario);
            return this.responseBuilder.buildResponse(INVALID_OWNER_USER_ERROR, e);
        } catch (Exception e) {
            LOG.error("Error updating realestate post " + aviso.getIdAviso() + ". Detail: " + aviso + ".", e);
            return this.responseBuilder.buildResponse(UNKNOWN_ERROR, e);
        }
    }

    @Override
    public WebServiceResponse publicar(String usuario, Long proveedor, String password, Boolean dryRun, Aviso aviso) {
        try {
            aviso.setPais(new BusinessDomain(aviso.getPais()).getCountryCode());
            preProcessAviso(aviso, proveedor);
            Errors errors = this.validateAvisoIgi(aviso, proveedor);
            if (errors.getErrorCount() > 0) {
                logValidationErrors(aviso, errors);
                return this.responseBuilder.buildIntegerResponse(MESSAGE_FORMAT_ERROR, null, errors);
            } else if (!shouldProcess(dryRun)) {
                return this.responseBuilder.buildStringResponse(SUCCESS, "test ok");
            }

            ProviderNews providerNews = this.newsAdapter
                    .getImportedProviderNews(aviso.getIdAvisoProveedor(), proveedor);

            return processPublicarRequest(usuario, proveedor, aviso, providerNews);

        } catch (Exception e) {
            LOG.error("Error saving realestate " + aviso.getIdAvisoProveedor() + ". Detail: " + aviso + ".", e);
            return this.responseBuilder.buildIntegerResponse(ServiceReturnCode.UNKNOWN_ERROR, null, e);
        }
    }

    @Override
    public WebServiceIntegerResponse publicarAviso(String usuario, Long proveedor, String password, Aviso aviso) {
        try {
            aviso.setPais(new BusinessDomain(aviso.getPais()).getCountryCode());

            preProcessAviso(aviso, proveedor);

            Errors errors = this.validateAviso(aviso, proveedor);
            if (errors.getErrorCount() > 0) {
                logValidationErrors(aviso, errors);
                return this.responseBuilder.buildIntegerResponse(MESSAGE_FORMAT_ERROR, null, errors);
            }
            Optional<WebServiceIntegerResponse> errorResponse = validatePostAddition(proveedor, usuario,
                    RealEstateTypeEnum.BUILDING_UNIT);
            if (errorResponse.isPresent()) {
                return errorResponse.get();
            }

            Long postId = navPlatClient.post(usuario, proveedor, aviso);
            aviso.setIdAviso(postId);
            WebServiceIntegerResponse response = this.responseBuilder.buildIntegerResponse(SUCCESS, postId.intValue());
            return response;

        } catch (Exception e) {
            LOG.error("Error publishing realestate " + aviso.getIdAvisoProveedor() + ". Detail: " + aviso + ".", e);
            return this.responseBuilder.buildIntegerResponse(ServiceReturnCode.UNKNOWN_ERROR, null, e);
        }
    }

    @Override
    public WebServiceResponse publicarInternal(String usuario, Long proveedor, String password, Boolean dryRun,
            Aviso aviso) {
        return this.publicar(usuario, proveedor, password, dryRun, aviso);
    }

    @Override
    public WebServiceResponse publishProject(String providerUserId, Long providerId, String password,
            IgiProjectPost igiProjectPost) {
        try {
            Errors errors = new SimpleErrors("igiProjectPost", igiProjectPost);
            this.igiPostProviderValidator.validate(igiProjectPost, errors);
            if (errors.getErrorCount() > 0) {
                logValidationErrors(igiProjectPost, errors);
                return this.responseBuilder.buildIntegerResponse(MESSAGE_FORMAT_ERROR, null, errors);
            }

            ProviderNews providerNews = this.newsAdapter.getImportedProviderNews(igiProjectPost.getIdAvisoProveedor(),
                    providerId);

            WebServiceResponse response;
            if (providerNews != null) {
                igiProjectPost.setIdAviso(providerNews.getPostId());

                if (!this.navPlatClient.isBuildingProject(providerNews.getPostId())) {
                    String message = "Attempted to modify project " + igiProjectPost.getIdAvisoProveedor()
                            + " of provider " + providerId + " but the existing Post is not a Project Post.";
                    LOG.warn(message);
                    return this.responseBuilder.buildIntegerResponse(INVALID_POST_OPERATION_ERROR, null, message);
                }

                this.newsAdapter.adaptPostProviderNews(igiProjectPost, providerId, true);
                response = this.updateProject(providerUserId, providerId, igiProjectPost);
            } else {
                response = this.publishNewProject(providerUserId, providerId, igiProjectPost);

                if (response.getReturnCode() == 0) {
                    this.newsAdapter.adaptPostProviderNews(igiProjectPost, providerId, false);
                }
            }

            return response;

        } catch (Exception e) {
            LOG.error("Error publishing project " + igiProjectPost.getIdAvisoProveedor() + ".", e);
            return this.responseBuilder.buildIntegerResponse(ServiceReturnCode.UNKNOWN_ERROR, null, e);
        }
    }

    private void checkIfProviderOwnedAPost(Long provider, Long adId) throws UnknownUserException {

        if (!navPlatClient.checkIfProviderOwnedAPost(provider, adId)) {
            throw new UnknownUserException();
        }
    }

    private Long createValidAdIdFromString(String number) {
        if (!StringUtils.isBlank(number)) {
            return Long.valueOf(number);
        }

        return null;
    }

    private WebServiceResponse finishPost(Long provider, Integer postId, Boolean changeProviderNewsToNotProcessable) {

        Long userId = this.getContextZpUserId();
        try {
            NavPlatPost post = this.navPlatClient.get(valueOf(postId), userId).orElse(null);

            this.navPlatClient.finishPost(post.getId(), changeProviderNewsToNotProcessable);

            return this.responseBuilder.buildResponse(SUCCESS);

            // } catch (UnknownPostIdException e) {
            // LOG.warn("Error finalizando publicación id aviso: " + postId + " - " + e.getMessage());
            // return this.responseBuilder.buildResponse(UNKNOWN_POST_ID_ERROR, e);
            // } catch (InvalidPostOperationException e) {
            // LOG.warn("Error finalizando publicación id aviso: " + postId + " - " + e.getMessage());
            // return this.responseBuilder.buildResponse(INVALID_POST_OPERATION_ERROR, e);
            // } catch (InvalidOwnerUserException e) {
            // LOG.warn("Error finalizando publicación id aviso: " + postId + " - " + e.getMessage() + " id usuario: "
            // + userId);
            // return this.responseBuilder.buildResponse(INVALID_OWNER_USER_ERROR, e);
        } catch (Exception e) {
            LOG.error("Error finalizando publicación id aviso: " + postId, e);
            return this.responseBuilder.buildResponse(UNKNOWN_ERROR, e);
        }

    }

    private Long getContextZpUserId() {
        throw new UnsupportedOperationException();
    }

    private void logValidationErrors(IgiRealEstatePost igiRealEstatePost, Errors errors) {
        LOG.warn("External ad " + igiRealEstatePost.getIdAvisoProveedor() + " is invalid: " + errors);
        if (LOG.isDebugEnabled()) {
            LOG.debug("External ad details:" + igiRealEstatePost);
        }
    }

    private void modifyZpPost(String usuario, Long proveedor, Aviso aviso) throws Exception {

        Long userId = this.getContextZpUserId();

        ModifyPostBusinessCommand command = this.postAdapter.adaptToModifyPostCommand(aviso,
                new BusinessDomain(aviso.getPais()), userId, proveedor);
        this.navPlatClient.updatePost(command);
    }

    private void preProcessAviso(Aviso aviso, Long proveedor) {
        this.postSubtitlePreProcessor.preProcess(aviso, proveedor);
        // tengo que hacer adaptaciones sobre los IS antes de validarlo.
        // TODO: validar concepto antes, en vez de tener que hacer IFs adentro de IgiSpecificationsAdapterHelper (no
        // llamar a adaptAvisoSpecification si da error)
        aviso.setEspecificaciones(new ArrayList<>(this.specificationsAdapter.adaptAvisoSpecification(aviso)));
        aviso.getContacto().adaptContactPhone();
    }

    private WebServiceResponse processPublicarRequest(String usuario, Long proveedor, Aviso aviso,
            ProviderNews providerNews) throws Exception {
        WebServiceResponse response;
        if (providerNews != null) {
            aviso.setIdAviso(providerNews.getPostId());

            if (providerNews.isBuildingProject()) {
                String message = "Attempted to modify unit " + aviso.getIdAvisoProveedor() + " of provider "
                        + proveedor + " but the existing Post is not a unit Post.";
                LOG.warn(message);
                return this.responseBuilder.buildIntegerResponse(ServiceReturnCode.INVALID_POST_OPERATION_ERROR, null,
                        message);
            }

            this.newsAdapter.adaptPostProviderNews(aviso, proveedor, true);

            modifyZpPost(usuario, proveedor, aviso);

            response = this.responseBuilder.buildResponse(SUCCESS);
        } else {
            Optional<WebServiceIntegerResponse> errorResponse = validatePostAddition(proveedor, usuario,
                    RealEstateTypeEnum.BUILDING_UNIT);
            if (errorResponse.isPresent()) {
                return errorResponse.get();
            }

            Long postId = navPlatClient.post(usuario, proveedor, aviso);

            aviso.setIdAviso(postId);

            response = this.responseBuilder.buildIntegerResponse(SUCCESS, postId.intValue());

            if (response.getReturnCode() == 0) { // no es siempre 0 ac�?
                this.newsAdapter.adaptPostProviderNews(aviso, proveedor, false);
            }
        }

        return response;
    }

    private WebServiceIntegerResponse publishNewProject(String providerUserId, Long providerId,
            IgiProjectPost igiProjectPost) {
        try {
            igiProjectPost.setPais(new BusinessDomain(igiProjectPost.getPais()).getCountryCode());

            filterValidBlueprint(igiProjectPost);
            Errors errors = new SimpleErrors("project", igiProjectPost);
            igiProjectPost.getContact().adaptContactPhone();
            this.igiProjectPostValidator.validate(igiProjectPost, errors);
            if (errors.getErrorCount() > 0) {
                logValidationErrors(igiProjectPost, errors);
                return this.responseBuilder.buildIntegerResponse(MESSAGE_FORMAT_ERROR, null, errors);
            }
            Optional<WebServiceIntegerResponse> errorResponse = validatePostAddition(providerId, providerUserId,
                    RealEstateTypeEnum.BUILDING_PROJECT);
            if (errorResponse.isPresent()) {
                return errorResponse.get();
            }

            NavPlatUser user = this.navPlatClient.getUser(this.getContextZpUserId());

            NewFullProjectPostOperation projectOperation = this.projectPostAdapter.adaptToNewProjectOperation(
                    igiProjectPost, user, providerId);

            Long postId = navPlatClient.postProject(projectOperation);

            igiProjectPost.setIdAviso(postId);

            return this.responseBuilder.buildIntegerResponse(SUCCESS, postId.intValue());
        } catch (Exception e) {
            LOG.error("Error publishing post " + igiProjectPost + ".", e);
            return this.responseBuilder.buildIntegerResponse(ServiceReturnCode.UNKNOWN_ERROR, null, e);
        }
    }

    private boolean shouldProcess(Boolean testMode) {
        if (testMode == null || testMode.equals(FALSE)) {
            return true;
        }
        return false;
    }

    private WebServiceResponse updateProject(String providerUserId, Long providerId, IgiProjectPost igiProjectPost) {
        try {
            igiProjectPost.setPais(new BusinessDomain(igiProjectPost.getPais()).getCountryCode());
            filterValidBlueprint(igiProjectPost);
            Errors errors = new SimpleErrors("project", igiProjectPost);
            igiProjectPost.getContact().adaptContactPhone();
            this.igiProjectPostValidator.validate(igiProjectPost, errors);
            if (errors.getErrorCount() > 0) {
                logValidationErrors(igiProjectPost, errors);
                return this.responseBuilder.buildResponse(MESSAGE_FORMAT_ERROR, errors);
            }

            NavPlatUser user = this.navPlatClient.getUser(this.getContextZpUserId());

            NavPlatPost post = navPlatClient.get(igiProjectPost.getIdAviso(), user.getId()).orElse(null);

            EditFullProjectPostOperation operation = this.projectPostAdapter.adaptToEditProjectOperation(
                    igiProjectPost, post);

            navPlatClient.updateProject(operation);

            return this.responseBuilder.buildResponse(SUCCESS);
            // } catch (G7Exception ex) {
            // LOG.warn("Error updating project " + igiProjectPost.getIdAviso() + " for user " + providerUserId + ". "
            // + ex.getMessage());
            // return this.responseBuilder.buildResponse(ex.getErrorCode(), ex);
        } catch (Exception ex) {
            LOG.warn("Error updating project " + igiProjectPost.getIdAviso() + " for user " + providerUserId + ".", ex);
            return this.responseBuilder.buildResponse(ServiceReturnCode.UNKNOWN_ERROR, ex);
        }
    }

    private Errors validateAviso(Aviso aviso, Long postProviderId) {
        Errors errors = new SimpleErrors("aviso", aviso);
        this.avisoValidator.validate(aviso, errors);
        return errors;
    }

    private Errors validateAvisoIgi(Aviso aviso, Long postProviderId) {
        Errors errors = this.validateAviso(aviso, postProviderId);
        this.igiPostProviderValidator.validate(aviso, errors);
        return errors;
    }

    private void validatePost(Long adId, Long provider) throws UnknownUserException {
        if (adId != null) {
            this.checkIfProviderOwnedAPost(provider, adId);
        }
    }

    private Optional<WebServiceIntegerResponse> validatePostAddition(Long postProviderId, String providerUserId,
            RealEstateTypeEnum realEstateType) {
        boolean valid = this.providerUserValidationService.validatePostAddition(postProviderId, providerUserId,
                realEstateType);
        if (valid) {
            return Optional.empty();
        }
        WebServiceIntegerResponse integerResponse = this.responseBuilder.buildIntegerResponse(
                ServiceReturnCode.ADS_LIMIT_REACHED_ERROR, null, "Max amount of " + realEstateType.getLabel()
                        + " posts reached.");
        return Optional.of(integerResponse);
    }

    protected void filterValidBlueprint(IgiProjectPost post) {
        for (IgiProjectUnit igiProjectUnit : post.getUnits()) {
            List<String> filteredBlueprintUrls = new ArrayList<String>();
            if (igiProjectUnit.getBlueprintUrl() != null && !igiProjectUnit.getBlueprintUrl().isEmpty()) {

                // private final Predicate<String> predicate = new Predicate<String>() {
                // @Override
                // public boolean apply(String toEvaluate) {
                // String possibleUrl = toEvaluate;
                // return GenericValidator.isUrl(possibleUrl);
                // }
                // };

                // filteredBlueprintUrls = newArrayList(Iterables.filter(igiProjectUnit.getBlueprintUrl(), predicate));
                throw new UnsupportedOperationException("fix me");
            }
            igiProjectUnit.setBlueprintUrl(filteredBlueprintUrls);
        }
    }

}
