package com.dridco.inmuebles.ws.g7.model;

public class WebServiceIntegerResponse extends WebServiceResponse {

    private static final String DEFAULT_MESSAGE = "";
    private Integer intergerValue;

    public WebServiceIntegerResponse() {
    }

    public WebServiceIntegerResponse(Integer returnCode, String errorDescription, Integer integerValue) {
        super(returnCode, errorDescription);
        this.intergerValue = integerValue;
    }

    public Integer getIntergerValue() {
        return this.intergerValue;
    }

    public void setIntergerValue(Integer intergerValue) {
        this.intergerValue = intergerValue;
    }

    public static WebServiceIntegerResponse created(Long navPlatPostId) {
        return new WebServiceIntegerResponse(0, DEFAULT_MESSAGE, navPlatPostId.intValue());
    }

}
