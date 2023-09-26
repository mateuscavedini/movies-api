package io.github.mateuscavedini.moviesapi.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
    private String exception;
    private String message;
    private LocalDateTime timestamp = LocalDateTime.now();

    public ExceptionResponse(String exception, String message) {
        this.exception = exception;
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
