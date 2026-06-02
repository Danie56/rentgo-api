package com.rentgo.rentgo_api.common.exceptions;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class ErrorMessage {
    private LocalDateTime timestamp;
    private String message;
    private String exception;
    private String path;
    private Map<String, String> errors;

    public ErrorMessage(LocalDateTime timestamp,  String message, String exception, String path, Map<String, String> errors) {
        this.timestamp = timestamp;
        this.message = message;
        this.exception = exception;
        this.path = path;
        this.errors = errors;
    }

    public ErrorMessage(LocalDateTime timestamp, String message, String exception, String path) {
        this.timestamp = timestamp;
        this.message = message;
        this.exception = exception;
        this.path = path;
        this.errors = new HashMap<>();
    }
}
