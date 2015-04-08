package com.navent.integrations.igi.validation;

import org.springframework.validation.Errors;

public class InvalidRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final Errors errors;

    public InvalidRequestException(Errors errors) {
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }
}
