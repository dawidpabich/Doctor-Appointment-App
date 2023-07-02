package com.example.DoctorAppointmentApp.exception.doctor;

import com.example.DoctorAppointmentApp.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class DoctorNotFoundException extends BusinessException {

    public DoctorNotFoundException() {
        super("Doctor not found", HttpStatus.NOT_FOUND);
    }
}
