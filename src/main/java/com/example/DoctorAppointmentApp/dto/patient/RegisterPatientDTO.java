package com.example.DoctorAppointmentApp.dto.patient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterPatientDTO {
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;
}
