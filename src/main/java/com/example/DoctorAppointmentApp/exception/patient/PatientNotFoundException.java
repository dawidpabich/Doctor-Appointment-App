package com.example.DoctorAppointmentApp.exception.patient;

import com.example.DoctorAppointmentApp.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class PatientNotFoundException extends BusinessException {
    public PatientNotFoundException() {
        super("Patient not found", HttpStatus.NOT_FOUND);
    }
}
