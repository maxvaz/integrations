package com.dridco.inmuebles.ws.g7.model;

public class WebServiceResponse {

    private Integer returnCode;
    private String errorDescription;

    public WebServiceResponse() {

    }

    public WebServiceResponse(Integer returnCode, String errorDescription) {
        this.errorDescription = errorDescription;
        this.returnCode = returnCode;
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
