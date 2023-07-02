package com.example.DoctorAppointmentApp.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessExceptions(BusinessException businessException) {
        return ResponseEntity
                .status(businessException.httpStatus)
                .body(ErrorResponse.builder().
                        message(businessException.message)
                        .build());

    }


    @Builder
    @Getter
    public static class ErrorResponse {
        private String message;
    }
}
