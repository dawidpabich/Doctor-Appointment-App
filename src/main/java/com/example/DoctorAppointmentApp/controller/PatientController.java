package com.example.DoctorAppointmentApp.controller;

import com.example.DoctorAppointmentApp.dto.patient.EditPatientDTO;
import com.example.DoctorAppointmentApp.dto.patient.PatientDTO;
import com.example.DoctorAppointmentApp.dto.patient.RegisterPatientDTO;
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

    @GetMapping
    public List getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public PatientDTO getPatientByID(@PathVariable long id){
        return patientService.getPatientById(id);
    }


    @DeleteMapping("/{id}")
    public void deletePatientById(@PathVariable long id){
        patientService.deletePatientById(id);
    }

    @PutMapping("/{id}")
    public PatientDTO editPatient(@PathVariable long id, @Valid @RequestBody EditPatientDTO editPatientDTO){
        return patientService.editPatient(id, editPatientDTO);
    }
    
}
