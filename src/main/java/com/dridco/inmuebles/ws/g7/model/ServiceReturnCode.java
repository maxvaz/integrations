package com.dridco.inmuebles.ws.g7.model;

public enum ServiceReturnCode {

    // @formatter:off
    SUCCESS(0), 
    AUTHENTICATION_ERROR(1), 
    UNKNOWN_ERROR(-1), 
    INVALID_OWNER_USER_ERROR(201), 
    INVALID_POST_OPERATION_ERROR(202), 
    UNKNOWN_POST_ID_ERROR(203), 
    UNKNOWN_POST_PROVIDER_ERROR(204), 
    IMPORT_IN_PROGRESS_ERROR(205), 
    ADS_LIMIT_REACHED_ERROR(206), 
    MESSAGE_FORMAT_ERROR(301);
    // @formatter:on

    private int id;

    ServiceReturnCode(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static ServiceReturnCode getById(int id) {
        for (ServiceReturnCode serviceReturnCode : ServiceReturnCode.values()) {
            if (serviceReturnCode.getId() == id) {
                return serviceReturnCode;
            }
        }
        return null;
    }

}
