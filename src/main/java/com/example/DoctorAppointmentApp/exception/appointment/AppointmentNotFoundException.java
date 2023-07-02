package com.example.DoctorAppointmentApp.exception.appointment;

import com.example.DoctorAppointmentApp.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class AppointmentNotFoundException extends BusinessException {
    public AppointmentNotFoundException() {
        super("Appointment not found", HttpStatus.NOT_FOUND);
    }
}
