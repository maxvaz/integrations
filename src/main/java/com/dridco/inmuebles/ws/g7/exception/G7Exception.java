package com.dridco.inmuebles.ws.g7.exception;

import com.dridco.inmuebles.ws.g7.model.ServiceReturnCode;

/**
 * @author pfenoglio@dridco.com
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
public class G7Exception extends Exception {
    private static final long serialVersionUID = 1L;

    private final ServiceReturnCode errorCode;

    public G7Exception(ServiceReturnCode errorCode) {
        this.errorCode = errorCode;
    }

    public G7Exception() {
        this(null);
    }

    public ServiceReturnCode getErrorCode() {
        return this.errorCode;
    }

}
