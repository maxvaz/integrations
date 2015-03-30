package com.dridco.inmuebles.ws.g7.exception;

public class UnknownUserException extends G7Exception {
    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return "No existe un proveedor con el usuario y proveedor especificado.";
    }
}
