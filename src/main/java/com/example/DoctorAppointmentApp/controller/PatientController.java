package com.example.DoctorAppointmentApp.controller;

import com.example.DoctorAppointmentApp.dto.doctor.DoctorDTO;
import com.example.DoctorAppointmentApp.dto.doctor.EditDoctorDTO;
import com.example.DoctorAppointmentApp.dto.doctor.RegisterDoctorDTO;
import com.example.DoctorAppointmentApp.dto.patient.EditPatientDTO;
import com.example.DoctorAppointmentApp.dto.patient.PatientDTO;
import com.example.DoctorAppointmentApp.dto.patient.RegisterPatientDTO;
import com.example.DoctorAppointmentApp.model.doctors.DoctorSpeciality;
import com.example.DoctorAppointmentApp.service.definition.PatientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/patients")
public class PatientController {
    
    private final PatientService patientService;

    @PostMapping
    public PatientDTO registerPatient(@RequestBody RegisterPatientDTO registerPatientDTO){
        return patientService.registerPatient(registerPatientDTO);
    }

    @GetMapping("/list")
    public List getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public PatientDTO getPatientByID(@PathVariable int id){
        return patientService.getPatientById(id);
    }


    @DeleteMapping
    public void deletePatientById(int id){
        patientService.deletePatientById(id);
    }

    @PutMapping
    public PatientDTO editPatient(int id, @Valid @RequestBody EditPatientDTO editPatientDTO){
        return patientService.editPatient(id, editPatientDTO);
    }
    
}
