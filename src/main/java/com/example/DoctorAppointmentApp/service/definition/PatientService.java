package com.example.DoctorAppointmentApp.service.definition;

import com.example.DoctorAppointmentApp.dto.patient.EditPatientDTO;
import com.example.DoctorAppointmentApp.dto.patient.PatientDTO;
import com.example.DoctorAppointmentApp.dto.patient.RegisterPatientDTO;

import java.util.List;

public interface PatientService {
    PatientDTO registerPatient(RegisterPatientDTO patient);
    List<PatientDTO> getAllPatients();
    PatientDTO getPatientById(long id);

    void deletePatientById(long id);
    PatientDTO editPatient(long id, EditPatientDTO Patient);
}
