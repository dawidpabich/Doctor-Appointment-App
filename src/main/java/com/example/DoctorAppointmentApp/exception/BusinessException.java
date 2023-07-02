package com.example.DoctorAppointmentApp.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter

public class BusinessException extends RuntimeException {
    protected final String message;
    protected final HttpStatus httpStatus;

    public BusinessException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
