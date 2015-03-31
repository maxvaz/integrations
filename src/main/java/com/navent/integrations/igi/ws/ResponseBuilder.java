package com.navent.integrations.igi.ws;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.dridco.inmuebles.ws.g7.model.ServiceReturnCode;
import com.dridco.inmuebles.ws.g7.model.WebServiceIntegerResponse;
import com.dridco.inmuebles.ws.g7.model.WebServiceResponse;

/**
 * @author aobara@dridco.com
 * @author aruiz@dridco.com (Alejandro Lopez Ruiz)
 */
@Component
public class ResponseBuilder {

    private static final String DEFAULT_MESSAGE = "";

    public WebServiceIntegerResponse buildIntegerResponse(ServiceReturnCode code, Integer response) {
        return new WebServiceIntegerResponse(code.getId(), DEFAULT_MESSAGE, response);
    }

    public WebServiceResponse buildStringResponse(ServiceReturnCode code, String response) {
        return new WebServiceResponse(code.getId(), response);
    }

    public WebServiceIntegerResponse buildIntegerResponse(ServiceReturnCode code, Integer response, Errors errors) {
        return new WebServiceIntegerResponse(code.getId(), this.buildErrorMessage(errors), response);
    }

    public WebServiceIntegerResponse buildIntegerResponse(ServiceReturnCode code, Integer response, String errorMessage) {
        return new WebServiceIntegerResponse(code.getId(), errorMessage, response);
    }

    public WebServiceIntegerResponse buildIntegerResponse(ServiceReturnCode code, Integer response, Throwable e) {
        return new WebServiceIntegerResponse(code.getId(), this.buildErrorMessage(e), response);
    }

    public WebServiceResponse buildResponse(ServiceReturnCode code) {
        return new WebServiceResponse(code.getId(), DEFAULT_MESSAGE);
    }

    public WebServiceResponse buildResponse(ServiceReturnCode code, Errors errors) {
        return new WebServiceResponse(code.getId(), this.buildErrorMessage(errors));
    }

    public WebServiceResponse buildResponse(ServiceReturnCode code, Throwable e) {
        return new WebServiceResponse(code.getId(), this.buildErrorMessage(e));
    }

    private String buildErrorMessage(Errors errors) {
        StringBuilder sb = new StringBuilder();

        for (Object obj : errors.getAllErrors()) {
            ObjectError error = (ObjectError) obj;
            sb.append(error.getCode());
            sb.append(": ");
            sb.append(error.getObjectName());
            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                sb.append(fieldError.getField());
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private String buildErrorMessage(Throwable e) {
        return e.getMessage();
    }

}
