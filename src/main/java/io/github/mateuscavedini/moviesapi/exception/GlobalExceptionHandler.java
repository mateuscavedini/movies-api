package io.github.mateuscavedini.moviesapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleRoleNotFoundException(RoleNotFoundException exception) {
        ExceptionResponse body = new ExceptionResponse("Role not found", exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(ListTypeNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleListTypeNotFoundException(ListTypeNotFoundException exception) {
        ExceptionResponse body = new ExceptionResponse("List type not found", exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleMovieNotFoundException(MovieNotFoundException exception) {
        ExceptionResponse body = new ExceptionResponse("Movie not found", exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleUserNotFoundException(UserNotFoundException exception) {
        ExceptionResponse body = new ExceptionResponse("User not found", exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(ListNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleListNotFoundException(ListNotFoundException exception) {
        ExceptionResponse body = new ExceptionResponse("List not found", exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse> handleGeneralException(RuntimeException exception) {
        ExceptionResponse body = new ExceptionResponse("Internal Server Error", exception.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}
