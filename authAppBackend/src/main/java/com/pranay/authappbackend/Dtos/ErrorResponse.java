package com.pranay.authappbackend.Dtos;

import java.time.Instant;

public record ErrorResponse(
        Instant timeStamp,
        String message,
        Integer statusCode,
        String status,
        String path

) {
    public ErrorResponse(String message, Integer status, String statusCode, String path) {
        this(Instant.now(), message, status, statusCode, path);
    }
}
