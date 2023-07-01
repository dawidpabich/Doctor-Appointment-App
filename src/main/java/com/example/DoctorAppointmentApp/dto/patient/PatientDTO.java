package com.example.DoctorAppointmentApp.dto.patient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientDTO {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;
}
