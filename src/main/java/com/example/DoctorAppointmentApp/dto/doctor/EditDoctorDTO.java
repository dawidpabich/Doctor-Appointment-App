package com.example.DoctorAppointmentApp.dto.doctor;

import com.example.DoctorAppointmentApp.model.doctors.DoctorSpeciality;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditDoctorDTO {
    private String firstName;
    private String lastName;
    private DoctorSpeciality doctorSpeciality;
}