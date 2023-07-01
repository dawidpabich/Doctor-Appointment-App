package com.example.DoctorAppointmentApp.service.definition;

import com.example.DoctorAppointmentApp.dto.doctor.DoctorDTO;
import com.example.DoctorAppointmentApp.dto.doctor.EditDoctorDTO;
import com.example.DoctorAppointmentApp.dto.doctor.RegisterDoctorDTO;
import com.example.DoctorAppointmentApp.model.doctors.DoctorSpeciality;

import java.util.List;

public interface DoctorService {
    DoctorDTO registerDoctor(RegisterDoctorDTO doctor);
    List<DoctorDTO> getAllDoctors();
    DoctorDTO getDoctorById(int id);
    List<DoctorDTO> getDoctorsBySpeciality(DoctorSpeciality doctorSpeciality);
    void deleteDoctorById(int id);
    DoctorDTO editDoctor(int id, EditDoctorDTO doctor);

}
