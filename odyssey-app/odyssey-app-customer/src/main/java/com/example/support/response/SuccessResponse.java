package com.example.support.response;

import org.springframework.http.HttpStatus;

public record SuccessResponse<T>(
        int code,
        String message,
        T data
) {

    private static final String SUCCESS_STATUS = "success";

    private SuccessResponse(HttpStatus httpStatus, T data) {
        this(httpStatus.value(), httpStatus.getReasonPhrase(), data);
    }

    public static <T> SuccessResponse<T> ok(T data) {
        return new SuccessResponse<>(HttpStatus.OK, data);
    }

    public static SuccessResponse<Void> emptyData() {
        return new SuccessResponse<>(HttpStatus.OK, null);
    }

    public static <T> SuccessResponse<T> created(T data) {
        return new SuccessResponse<>(HttpStatus.CREATED, data);
    }

    public static <T> SuccessResponse<T> of(HttpStatus httpStatus, T data) {
        return new SuccessResponse<>(httpStatus, data);
    }
}
