package com.navent.ws.security;

import java.util.List;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Element;

import com.dridco.inmuebles.ws.g7.service.RealEstateService;

/**
 * @author pfenoglio
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
@Component
public class AuthenticationInInterceptor extends AbstractPhaseInterceptor<Message> {

    private final ProviderDomain providerDomain;
    private final WebServiceContext context;

    @Autowired
    public AuthenticationInInterceptor(ProviderDomain providerDomain, WebServiceContext context) {
        super(Phase.PRE_PROTOCOL);
        this.providerDomain = providerDomain;
        this.context = context;
    }

    private void checkPassword(List<SoapHeader> headers, ProviderPost provider) {
        final String password = readHeader(headers, "password");
        final boolean isAuthenticated = provider.getPassword() == null || provider.getPassword().equals(password);
        if (!isAuthenticated) {
            throw new RuntimeException("Invalid authentication.");
        }
    }

    private ProviderUser checkUser(List<SoapHeader> headers, ProviderPost provider) {
        String user = readHeader(headers, RealEstateService.ES_USER_PARAM);

        user = (user == null) ? readHeader(headers, RealEstateService.EN_USER_PARAM) : user;

        final ProviderUser providerUser = this.providerDomain.getProviderUser(user, provider);
        if (providerUser == null) {
            throw new RuntimeException("Invalid authentication.");
        }

        if (!ProviderUserState.ACTIVE.equals(providerUser.getImportStats())) {
            throw new RuntimeException("Provider user " + user + " is disabled.");
        }

        return providerUser;
    }

    private ProviderPost getAndValidateProvider(List<SoapHeader> headers) {
        String providerIdStr = this.readHeader(headers, RealEstateService.ES_PROVIDER_PARAM);
        providerIdStr = (providerIdStr == null) ? readHeader(headers, RealEstateService.EN_PROVIDER_PARAM)
                : providerIdStr;

        final Long providerId = Long.valueOf(providerIdStr);

        final ProviderPost provider = this.providerDomain.getPostProvider(providerId);

        if (provider == null) {
            throw new RuntimeException("Provider " + providerId + " not found.");
        }

        final boolean providerAllowed = provider.getCategory().equals(ProviderPostCategory.EXTERNAL);
        if (!providerAllowed) {
            throw new RuntimeException("Provider " + provider.getId() + " is not allowed to use this interface.");
        }
        return provider;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void handleMessage(Message message) throws Fault {
        final List<SoapHeader> headers = (List<SoapHeader>) message.get(Header.HEADER_LIST);

        final ProviderPost provider = getAndValidateProvider(headers);

        checkPassword(headers, provider);

        ProviderUser providerUser = checkUser(headers, provider);

        setProviderUserToWebServiceContext(providerUser);
    }

    private void setProviderUserToWebServiceContext(ProviderUser providerUser) {
        this.context.setProviderUser(providerUser);
    }

    private String readHeader(List<SoapHeader> headers, String headerTag) {
        try {
            for (SoapHeader soapHeader : headers) {
                if (soapHeader.getName().getLocalPart().equals(headerTag)) {
                    final Element element = (Element) soapHeader.getObject();
                    return element.getFirstChild().getTextContent();
                }
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Invalid header" + headerTag, e);
        }
    }

}
