package com.example.DoctorAppointmentApp.service.definition;

import com.example.DoctorAppointmentApp.dto.doctor.DoctorDTO;
import com.example.DoctorAppointmentApp.dto.doctor.EditDoctorDTO;
import com.example.DoctorAppointmentApp.dto.doctor.RegisterDoctorDTO;
import com.example.DoctorAppointmentApp.dto.patient.EditPatientDTO;
import com.example.DoctorAppointmentApp.dto.patient.PatientDTO;
import com.example.DoctorAppointmentApp.dto.patient.RegisterPatientDTO;
import com.example.DoctorAppointmentApp.model.doctors.DoctorSpeciality;

import java.util.List;

public interface PatientService {
    PatientDTO registerPatient(RegisterPatientDTO patient);
    List<PatientDTO> getAllPatients();
    PatientDTO getPatientById(int id);

    void deletePatientById(int id);
    PatientDTO editPatient(int id, EditPatientDTO Patient);
}
