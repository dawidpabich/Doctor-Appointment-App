package com.example.DoctorAppointmentApp.dto.Appointment;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RegisterAppointmentDTO {
    private LocalDateTime appointmentDate;
    private String additionalInformation;
    private long doctorID;
    private long patientID;
}
