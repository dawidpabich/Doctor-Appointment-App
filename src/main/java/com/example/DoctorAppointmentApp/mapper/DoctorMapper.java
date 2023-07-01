package com.example.DoctorAppointmentApp.mapper;

import com.example.DoctorAppointmentApp.dto.doctor.DoctorDTO;
import com.example.DoctorAppointmentApp.dto.doctor.RegisterDoctorDTO;
import com.example.DoctorAppointmentApp.model.doctors.Doctor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DoctorMapper {
    DoctorDTO mapDoctorToDoctorDTO(Doctor doctor);
    Doctor mapDoctorDTOToDoctor(RegisterDoctorDTO registerDoctorDTO);
    List<DoctorDTO> mapDoctorsToDoctorsDTO(List<Doctor> doctors);
}
