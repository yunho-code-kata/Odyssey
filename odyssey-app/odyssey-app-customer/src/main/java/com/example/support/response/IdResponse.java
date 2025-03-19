package com.example.support.response;

public record IdResponse(
        Long id
) {
    public static IdResponse from(Long id) {
        return new IdResponse(id);
    }
}
