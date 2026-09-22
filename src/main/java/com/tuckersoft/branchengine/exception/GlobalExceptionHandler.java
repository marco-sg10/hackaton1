package com.tuckersoft.branchengine.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Map<String, Object>> handleApiException(ApiException ex, HttpServletRequest request) {
        return buildResponse(ex.getStatus(), ex.getError(), ex.getMessage(), request);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        String msg = ex.getBindingResult().getFieldErrors().stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .findFirst()
                .orElse("Datos inválidos");
        return buildResponse(HttpStatus.BAD_REQUEST, "BAD_REQUEST", msg, request);
    }

    private ResponseEntity<Map<String, Object>> buildResponse(HttpStatus status, String error, String message, HttpServletRequest request) {
        Map<String, Object> data = new HashMap<>();
        data.put("error", error);
        data.put("message", message);
        data.put("timestamp", Instant.now().toString());
        data.put("path", request.getRequestURI());
        return ResponseEntity.status(status).body(data);
    }
}
