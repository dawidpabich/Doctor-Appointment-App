package com.example.DoctorAppointmentApp.service.implementation;

import com.example.DoctorAppointmentApp.dto.patient.EditPatientDTO;
import com.example.DoctorAppointmentApp.dto.patient.PatientDTO;
import com.example.DoctorAppointmentApp.dto.patient.RegisterPatientDTO;
import com.example.DoctorAppointmentApp.mapper.PatientMapper;
import com.example.DoctorAppointmentApp.model.patients.Patient;
import com.example.DoctorAppointmentApp.repository.PatientRepository;
import com.example.DoctorAppointmentApp.service.definition.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientMapper patientMapper;
    private final PatientRepository patientRepository;


    @Override
    public PatientDTO registerPatient(RegisterPatientDTO patient) {
        Patient patientToRegister = patientMapper.mapPatientDTOToPatient(patient);
        Patient registeredPatient = patientRepository.save(patientToRegister);
        return patientMapper.mapPatientToPatientDTO(registeredPatient);
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        return patientMapper.mapPatientsToPatientsDTO(
                (List<Patient>) patientRepository.findAll());
    }

    @Override
    public PatientDTO getPatientById(int id) {
        return patientMapper.
                mapPatientToPatientDTO(
                        patientRepository.
                                findById(id).
                                orElseThrow());
    }
    

    @Override
    public void deletePatientById(int id) {
        Patient Patient = patientRepository.findById(id).orElseThrow();
        patientRepository.delete(Patient);
    }

    @Override
    public PatientDTO editPatient(int id, EditPatientDTO patient) {
        Patient patientToEdit = patientRepository.findById(id).orElseThrow();

        patientToEdit.setFirstName(patient.getFirstName());
        patientToEdit.setLastName(patient.getLastName());
        patientToEdit.setPhone_number(patient.getPhoneNumber());
        patientToEdit.setAge(patient.getAge());

        Patient editedPatient = patientRepository.save(patientToEdit);
        PatientDTO editedPatientDTO = patientMapper.mapPatientToPatientDTO(patientToEdit);
        return editedPatientDTO;
    }
}
