package com.navent.integrations.igi.ws.security;

import static org.apache.cxf.phase.Phase.PRE_PROTOCOL;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.navent.integrations.igi.model.PostProviderGroup;
import com.navent.integrations.igi.model.PostProviderGroupRepository;
import com.navent.integrations.igi.model.ProviderUserRepository;
import com.navent.integrations.igi.ws.AuthenticationMessage;

@Component
public class AuthenticationInterceptor extends AbstractPhaseInterceptor<Message> {

    private final PostProviderGroupRepository postProviderRepository;
    private final ProviderUserRepository providerUserRepository;

    @Autowired
    public AuthenticationInterceptor(PostProviderGroupRepository postProviderRepository,
            ProviderUserRepository providerUserRepository) {
        super(PRE_PROTOCOL);
        this.postProviderRepository = postProviderRepository;
        this.providerUserRepository = providerUserRepository;
    }

    @Override
    public void handleMessage(Message nativeMessage) throws Fault {
        AuthenticationMessage message = new AuthenticationMessage(nativeMessage);

        PostProviderGroup postProvider = postProviderRepository.findById(message.getProviderId()).orElseThrow(
                InvalidAuthenticationException::new);

        if (!postProvider.checkPassword(message.getPassword())) {
            throw new InvalidAuthenticationException();
        }

        providerUserRepository.get(message.getProviderId(), message.getUser()).orElseThrow(
                InvalidAuthenticationException::new);
    }

}
