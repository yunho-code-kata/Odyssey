package com.example.exception;

public class BusinessException extends RuntimeException {

    private final BusinessError error;

    public BusinessException(BusinessError error) {
        super(error.getClientMessage());
        this.error = error;
    }
}
