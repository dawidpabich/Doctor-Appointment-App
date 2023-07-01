package com.example.DoctorAppointmentApp.dto.doctor;

import com.example.DoctorAppointmentApp.model.doctors.DoctorSpeciality;
import lombok.*;

@Getter
@Setter
public class DoctorDTO {
    private int id;
    private String firstName;
    private String lastName;
    private DoctorSpeciality doctorSpeciality;
}
