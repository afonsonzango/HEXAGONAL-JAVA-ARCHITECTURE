package com.richard.todo.root.configs.exceptions.mappers;

import com.richard.todo.root.shared.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class MethodArgumentNotValidExceptionMapper {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> toResponse(MethodArgumentNotValidException exception) {
        String message = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining("; "));

        if (message.isEmpty()) {
            message = exception.getBindingResult().getGlobalErrors().stream()
                    .map(error -> error.getObjectName() + ": " + error.getDefaultMessage())
                    .collect(Collectors.joining("; "));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponseDTO("VALIDATION_ERROR", message));
    }
}
