package com.dridco.inmuebles.ws.g7.service;

import static com.navent.integrations.igi.ws.security.ProviderUserPermission.PUBLISH_BP_POST;
import static com.navent.integrations.igi.ws.security.ProviderUserPermission.PUBLISH_POST;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

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
import com.navent.integrations.igi.ws.security.RequiredAccessPermissions;

/**
 * @author pfenoglio
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
@WebService
public interface RealEstateService {

    String NAMESPACE = "http://service.g7.ws.inmuebles.dridco.com/";
    String ES_USER_PARAM = "usuario";
    String EN_USER_PARAM = "user";
    String ES_PROVIDER_PARAM = "proveedor";
    String EN_PROVIDER_PARAM = "provider";

    @WebResult(name = "zona")
    List<Zona> consultarUbicaciones(@WebParam(name = ES_USER_PARAM, header = true) String usuario,
            @WebParam(name = ES_PROVIDER_PARAM, header = true) Long proveedor,
            @WebParam(name = "password", header = true) String password,
            @WebParam(name = "pais", header = true) String pais);

    @WebResult(name = "WebServiceResponse")
    WebServiceResponse finalizarAviso(@WebParam(name = ES_USER_PARAM, header = true) String usuario,
            @WebParam(name = ES_PROVIDER_PARAM, header = true) Long proveedor,
            @WebParam(name = "password", header = true) String password, @WebParam(name = "nroAviso") Integer id);

    @WebResult(name = "WebServiceResponse")
    @RequiredAccessPermissions(permissions = PUBLISH_POST)
    WebServiceResponse modificarAviso(@WebParam(name = ES_USER_PARAM, header = true) String usuario,
            @WebParam(name = ES_PROVIDER_PARAM, header = true) Long proveedor,
            @WebParam(name = "password", header = true) String password,
            @WebParam(name = "aviso", targetNamespace = NAMESPACE) Aviso aviso);

    @WebResult(name = "WebServiceIntegerResponse")
    @RequiredAccessPermissions(permissions = PUBLISH_POST)
    WebServiceIntegerResponse publicarAviso(@WebParam(name = ES_USER_PARAM, header = true) String usuario,
            @WebParam(name = ES_PROVIDER_PARAM, header = true) Long proveedor,
            @WebParam(name = "password", header = true) String password,
            @WebParam(name = "aviso", targetNamespace = NAMESPACE) Aviso aviso);

    @WebResult(name = "WebServiceIntegerResponse")
    @RequiredAccessPermissions(permissions = PUBLISH_POST)
    WebServiceResponse publicar(@WebParam(name = ES_USER_PARAM, header = true) String usuario,
            @WebParam(name = ES_PROVIDER_PARAM, header = true) Long proveedor,
            @WebParam(name = "password", header = true) String password,
            @WebParam(name = "dryRun", header = true) Boolean dryRun,
            @WebParam(name = "aviso", targetNamespace = NAMESPACE) Aviso aviso);

    @WebResult(name = "WebServiceResponse")
    WebServiceResponse finalizar(@WebParam(name = ES_USER_PARAM, header = true) String usuario,
            @WebParam(name = ES_PROVIDER_PARAM, header = true) Long proveedor,
            @WebParam(name = "password", header = true) String password,
            @WebParam(name = "nroAvisoProveedor") String providerId);

    @WebResult(name = "aviso", targetNamespace = NAMESPACE)
    Aviso consultarAviso(@WebParam(name = ES_USER_PARAM, header = true) String usuario,
            @WebParam(name = ES_PROVIDER_PARAM, header = true) Long proveedor,
            @WebParam(name = "password", header = true) String password, @WebParam(name = "idAviso") String id);

    @WebResult(name = "publications", targetNamespace = NAMESPACE)
    ConsultarPublicacionResponse consultarPublicaciones(@WebParam(name = ES_USER_PARAM, header = true) String usuario,
            @WebParam(name = ES_PROVIDER_PARAM, header = true) Long proveedor,
            @WebParam(name = "password", header = true) String password);

    @WebResult(name = "tiposInmuebles")
    List<String> consultarTiposInmueblesPorUbicacion(@WebParam(name = ES_USER_PARAM, header = true) String usuario,
            @WebParam(name = ES_PROVIDER_PARAM, header = true) Long proveedor,
            @WebParam(name = "password", header = true) String password,
            @WebParam(name = "pais", header = true) String pais, @WebParam(name = "idUbicacion") Integer idUbicacion);

    @WebResult
    GetLocationProjectTypesResponse getLocationProjectTypes(@WebParam(name = EN_USER_PARAM, header = true) String user,
            @WebParam(name = EN_PROVIDER_PARAM, header = true) Long provider,
            @WebParam(name = "password", header = true) String password,
            @WebParam(name = "country", header = true) String country, @WebParam(name = "locationId") Long locationId);

    @WebResult(name = "WebServiceIntegerResponse")
    @RequiredAccessPermissions(permissions = PUBLISH_BP_POST)
    WebServiceResponse publishProject(@WebParam(name = EN_USER_PARAM, header = true) String user,
            @WebParam(name = EN_PROVIDER_PARAM, header = true) Long provider,
            @WebParam(name = "password", header = true) String password,
            @WebParam(name = "project", targetNamespace = NAMESPACE) IgiProjectPost igiProjectPost);

    @WebResult(name = "WebServiceResponse")
    WebServiceResponse endRealEstatePost(@WebParam(name = EN_USER_PARAM, header = true) String user,
            @WebParam(name = EN_PROVIDER_PARAM, header = true) Long provider,
            @WebParam(name = "password", header = true) String password,
            @WebParam(name = "externalId") String externalId);

    @WebResult
    GetPublishedRealEstatesResponse getPublishedRealEstates(@WebParam(name = EN_USER_PARAM, header = true) String user,
            @WebParam(name = EN_PROVIDER_PARAM, header = true) Long provider,
            @WebParam(name = "password", header = true) String password);

    @WebResult(name = "webServiceResponse", targetNamespace = NAMESPACE)
    GetPostContactsResponse getRealEstateContacts(
            @WebParam(name = ES_USER_PARAM, header = true) String usuario,
            @WebParam(name = ES_PROVIDER_PARAM, header = true) Long proveedor,
            @WebParam(name = "password", header = true) String password,
            @WebParam(name = "getRealEstateContactsRequest", targetNamespace = NAMESPACE) GetRealEstateContactsRequest getRealEstateContactsRequest);

}
