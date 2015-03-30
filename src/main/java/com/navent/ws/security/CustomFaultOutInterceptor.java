package com.navent.ws.security;

import java.lang.reflect.UndeclaredThrowableException;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.FaultOutInterceptor;
import org.apache.cxf.message.Message;
import org.springframework.stereotype.Component;

/**
 * Este interceptor se creo con el fin de hacer compatibles, las Fault creadas por excepciones dentro de un In/Out
 * Interceptor y los que se definen dentro del implemenentor (authorizerMethodInterceptor).
 *
 * @author aobara
 *
 */
@Component
public class CustomFaultOutInterceptor extends FaultOutInterceptor {

    @Override
    public void handleMessage(Message message) throws Fault {
        Fault f = (Fault) message.getContent(Exception.class);

        Throwable cause = f.getCause();
        if (cause instanceof UndeclaredThrowableException) {
            f = new Fault(f.getCause().getCause());
        }

        message.setContent(Exception.class, f);
        super.handleMessage(message);
    }
}
