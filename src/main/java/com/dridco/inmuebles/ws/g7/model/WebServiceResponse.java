package com.dridco.inmuebles.ws.g7.model;

public class WebServiceResponse {

    private static final String DEFAULT_MESSAGE = "";

    private String errorDescription;
    private Integer returnCode;

    public WebServiceResponse() {
    }

    public WebServiceResponse(Integer returnCode) {
        this(returnCode, DEFAULT_MESSAGE);
    }

    public WebServiceResponse(Integer returnCode, String errorDescription) {
        this.errorDescription = errorDescription;
        this.returnCode = returnCode;
    }

    public static WebServiceResponse ok() {
        return new WebServiceResponse(0);
    }

    public String getErrorDescription() {
        return this.errorDescription;
    }

    public Integer getReturnCode() {
        return this.returnCode;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

}
