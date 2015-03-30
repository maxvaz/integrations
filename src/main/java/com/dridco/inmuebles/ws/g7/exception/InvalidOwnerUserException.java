package com.dridco.inmuebles.ws.g7.exception;

import com.dridco.inmuebles.ws.g7.model.ServiceReturnCode;

/**
 * @author pfenoglio@dridco.com
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
public class InvalidOwnerUserException extends G7Exception {
    private static final long serialVersionUID = 1L;

    public InvalidOwnerUserException() {
        super(ServiceReturnCode.INVALID_OWNER_USER_ERROR);
    }

    @Override
    public String getMessage() {
        return "El post no pertenece al usuario.";
    }

}
