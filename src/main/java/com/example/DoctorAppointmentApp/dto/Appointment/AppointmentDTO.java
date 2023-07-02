package com.example.DoctorAppointmentApp.dto.Appointment;

import com.example.DoctorAppointmentApp.dto.doctor.DoctorDTO;
import com.example.DoctorAppointmentApp.dto.patient.PatientDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentDTO {
    private long id;
    private LocalDateTime registerDate;
    private LocalDateTime appointmentDate;
    private String additionalInformation;
    private DoctorDTO doctor;
    private PatientDTO patient;
}
