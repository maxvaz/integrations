package com.dridco.inmuebles.ws.g7.exception;

import com.dridco.inmuebles.ws.g7.model.ServiceReturnCode;

/**
 * @author pfenoglio@dridco.com
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
public class InvalidPostOperationException extends G7Exception {
    private static final long serialVersionUID = 1L;

    public InvalidPostOperationException() {
        super(ServiceReturnCode.INVALID_POST_OPERATION_ERROR);
    }

    @Override
    public String getMessage() {
        return "La operaci�n que desea realizar no es v�lida para este post.";
    }

}
