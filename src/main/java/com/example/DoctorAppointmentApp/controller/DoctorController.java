package com.example.DoctorAppointmentApp.controller;

import com.example.DoctorAppointmentApp.dto.doctor.DoctorDTO;
import com.example.DoctorAppointmentApp.dto.doctor.EditDoctorDTO;
import com.example.DoctorAppointmentApp.dto.doctor.RegisterDoctorDTO;
import com.example.DoctorAppointmentApp.model.doctors.DoctorSpeciality;
import com.example.DoctorAppointmentApp.service.definition.DoctorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/doctors")
public class DoctorController {
    private DoctorService doctorService;

    @PostMapping
    public DoctorDTO registerDoctor(@RequestBody RegisterDoctorDTO registerDoctorDTO){
        return doctorService.registerDoctor(registerDoctorDTO);
    }

    @GetMapping("/list")
    public List getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public DoctorDTO getDoctorByID(@PathVariable int id){
        return doctorService.getDoctorById(id);
    }

    @GetMapping
    public List<DoctorDTO> getDoctorsBySpeciality(@RequestParam("doctorSpeciality") DoctorSpeciality doctorSpeciality){
        return doctorService.getDoctorsBySpeciality(doctorSpeciality);
    }


    @DeleteMapping
    public void deleteDoctorById(int id){
        doctorService.deleteDoctorById(id);
    }

    @PutMapping
    public DoctorDTO editDoctor(int id, @Valid @RequestBody EditDoctorDTO editDoctorDTO){
        return doctorService.editDoctor(id, editDoctorDTO);
    }
}
