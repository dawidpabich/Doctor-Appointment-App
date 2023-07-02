package com.example.DoctorAppointmentApp.dto.Appointment;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EditAppointmentDTO {
    private LocalDateTime appointmentDate;
}
