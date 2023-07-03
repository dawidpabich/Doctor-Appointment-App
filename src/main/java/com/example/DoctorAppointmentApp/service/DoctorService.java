package com.example.DoctorAppointmentApp.service;

import com.example.DoctorAppointmentApp.dto.doctor.DoctorDTO;
import com.example.DoctorAppointmentApp.dto.doctor.EditDoctorDTO;
import com.example.DoctorAppointmentApp.dto.doctor.RegisterDoctorDTO;
import com.example.DoctorAppointmentApp.model.doctors.DoctorSpeciality;

import java.util.List;

public interface DoctorService {
    DoctorDTO registerDoctor(RegisterDoctorDTO doctor);
    List<DoctorDTO> getAllDoctors();
    DoctorDTO getDoctorById(long id);
    List<DoctorDTO> getDoctorsBySpeciality(DoctorSpeciality doctorSpeciality);
    void deleteDoctorById(long id);
    DoctorDTO editDoctor(long id, EditDoctorDTO doctor);

}
