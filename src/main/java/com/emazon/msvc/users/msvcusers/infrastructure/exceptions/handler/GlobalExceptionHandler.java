package com.emazon.msvc.users.msvcusers.infrastructure.exceptions.handler;

import com.emazon.msvc.users.msvcusers.domain.exceptions.BusinessException;
import com.emazon.msvc.users.msvcusers.infrastructure.exceptions.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();

    ex.getBindingResult().getFieldErrors().forEach(error -> {
      String fieldName = error.getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });

    return ResponseEntity
            .badRequest()
            .body(errors);
  }

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ExceptionResponse> handleBusinessException(BusinessException ex) {
    return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(new ExceptionResponse(LocalDateTime.now(), ex.getCode(), ex.getMessage(), HttpStatus.BAD_REQUEST));
  }
}
