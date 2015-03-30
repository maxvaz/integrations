package com.dridco.inmuebles.ws.g7.exception;

import com.dridco.inmuebles.ws.g7.model.ServiceReturnCode;

/**
 * @author pfenoglio@dridco.com
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
public class UnknownProviderPostException extends G7Exception {
    private static final long serialVersionUID = 1L;

    public UnknownProviderPostException() {
        super(ServiceReturnCode.UNKNOWN_POST_PROVIDER_ERROR);
    }

    @Override
    public String getMessage() {
        return "No existe una novedad para el id de aviso externo y el provider user externo.";
    }

}
