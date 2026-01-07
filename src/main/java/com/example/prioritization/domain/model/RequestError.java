package com.example.prioritization.domain.model;

public enum RequestError {

    INVALID_REQUEST_TYPE("REQ-001", "Request type is not supported");

    private final String code;
    private final String message;

    RequestError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
