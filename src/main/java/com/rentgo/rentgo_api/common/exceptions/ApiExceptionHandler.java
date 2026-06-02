package com.rentgo.rentgo_api.common.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage badRequest(HttpServletRequest request, MethodArgumentNotValidException exception) {

        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(e -> {

            errors.put(e.getField(), e.getDefaultMessage());
        });
        return new ErrorMessage(LocalDateTime.now(), exception.getMessage(), exception.getClass().getSimpleName(), request.getRequestURI(), errors);

    }
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorMessage> handleBusinessException(
            BusinessException ex,
            HttpServletRequest request
    ) {

        ErrorMessage response = ErrorMessage.builder()
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(response);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleNotFoundException(
            ResourceNotFoundException ex,
            HttpServletRequest request
    ) {

        ErrorMessage response = ErrorMessage.builder()
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);
    }




}
