package com.example.DoctorAppointmentApp.mapper;

import com.example.DoctorAppointmentApp.dto.patient.PatientDTO;
import com.example.DoctorAppointmentApp.dto.patient.RegisterPatientDTO;
import com.example.DoctorAppointmentApp.model.patients.Patient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PatientMapper {
    PatientDTO mapPatientToPatientDTO(Patient patient);
    Patient mapPatientDTOToPatient(RegisterPatientDTO registerPatientDTO);
    List<PatientDTO> mapPatientsToPatientsDTO(List<Patient> patients);
}
