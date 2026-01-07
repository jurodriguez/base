package com.example.prioritization.domain.exceptions;

import com.example.prioritization.domain.model.RequestError;

public class BusinessException extends RuntimeException {

    private final String code;
    private final RequestError error;

    public BusinessException(RequestError error) {
        super(error.getMessage());
        this.code = error.getCode();
        this.error = error;
    }

    public String getCode() { return code; }

    public RequestError getError() { return error; }
}
