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

    @GetMapping
    public List getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public DoctorDTO getDoctorByID(@PathVariable long id){
        return doctorService.getDoctorById(id);
    }

    @GetMapping("/doctor-speciality")
    public List<DoctorDTO> getDoctorsBySpeciality(DoctorSpeciality doctorSpeciality){
        return doctorService.getDoctorsBySpeciality(doctorSpeciality);
    }


    @DeleteMapping("/{id}")
    public void deleteDoctorById(@PathVariable long id){
        doctorService.deleteDoctorById(id);
    }

    @PutMapping
    public DoctorDTO editDoctor(long id, @Valid @RequestBody EditDoctorDTO editDoctorDTO){
        return doctorService.editDoctor(id, editDoctorDTO);
    }
}
