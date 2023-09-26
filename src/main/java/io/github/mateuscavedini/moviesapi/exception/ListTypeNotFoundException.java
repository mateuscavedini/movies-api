package io.github.mateuscavedini.moviesapi.exception;

public class ListTypeNotFoundException extends RuntimeException {
    public ListTypeNotFoundException(String message) {
        super(message);
    }

    public ListTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
