package com.navent.ws.security;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author aobara
 *
 */
@Component
public class CleanContextOutInterceptor extends AbstractPhaseInterceptor<Message> {
    private final WebServiceContext context;

    @Autowired
    public CleanContextOutInterceptor(WebServiceContext context) {
        super(Phase.SETUP_ENDING);
        this.context = context;
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        this.context.setProviderUser(null);
    }

}
