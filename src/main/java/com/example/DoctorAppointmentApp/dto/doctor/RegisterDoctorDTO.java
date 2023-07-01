package com.example.DoctorAppointmentApp.dto.doctor;

import com.example.DoctorAppointmentApp.model.doctors.DoctorSpeciality;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDoctorDTO {
    private String firstName;
    private String lastName;
    private DoctorSpeciality doctorSpeciality;
}
