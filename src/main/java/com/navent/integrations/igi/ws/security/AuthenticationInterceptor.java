package com.navent.integrations.igi.ws.security;

import static org.apache.cxf.phase.Phase.PRE_PROTOCOL;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.navent.integrations.igi.model.repository.PostProviderRepository;
import com.navent.integrations.igi.model.repository.ProviderUserRepository;
import com.navent.integrations.igi.ws.AuthenticationMessage;

@Component
public class AuthenticationInterceptor extends AbstractPhaseInterceptor<Message> {

    private final PostProviderRepository postProviderRepository;
    private final ProviderUserRepository providerUserRepository;

    @Autowired
    public AuthenticationInterceptor(PostProviderRepository postProviderRepository,
            ProviderUserRepository providerUserRepository) {
        super(PRE_PROTOCOL);
        this.postProviderRepository = postProviderRepository;
        this.providerUserRepository = providerUserRepository;
    }

    @Override
    public void handleMessage(Message nativeMessage) throws Fault {
        AuthenticationMessage message = new AuthenticationMessage(nativeMessage);

        PostProviderGroup postProvider = postProviderRepository.get(message.getProviderId()).orElseThrow(
                InvalidAuthenticationException::new);

        if (!postProvider.checkPassword(message.getPassword())) {
            throw new InvalidAuthenticationException();
        }

        providerUserRepository.get(postProvider.getId(), message.getUser()).orElseThrow(
                InvalidAuthenticationException::new);
    }

}
