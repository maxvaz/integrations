package com.dridco.inmuebles.ws.g7.exception;

import com.dridco.inmuebles.ws.g7.model.ServiceReturnCode;

/**
 * @author pfenoglio@dridco.com
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
public class UnknownPostIdException extends G7Exception {
    private static final long serialVersionUID = 1L;

    public UnknownPostIdException() {
        super(ServiceReturnCode.UNKNOWN_POST_ID_ERROR);
    }

    @Override
    public String getMessage() {
        return "No existe un post con el id especificado.";
    }

}
