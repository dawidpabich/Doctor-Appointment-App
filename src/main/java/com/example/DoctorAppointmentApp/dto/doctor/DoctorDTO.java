package com.example.DoctorAppointmentApp.dto.doctor;

import com.example.DoctorAppointmentApp.model.doctors.DoctorSpeciality;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DoctorDTO {
    private long id;
    private String firstName;
    private String lastName;
    private DoctorSpeciality doctorSpeciality;
}
