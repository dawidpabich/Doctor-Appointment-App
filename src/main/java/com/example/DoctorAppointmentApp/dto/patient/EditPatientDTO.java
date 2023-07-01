package com.example.DoctorAppointmentApp.dto.patient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditPatientDTO {
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;
}
