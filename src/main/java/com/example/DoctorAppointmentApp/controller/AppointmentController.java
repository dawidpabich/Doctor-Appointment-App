package com.example.DoctorAppointmentApp.controller;

import com.example.DoctorAppointmentApp.dto.Appointment.AppointmentDTO;
import com.example.DoctorAppointmentApp.dto.Appointment.EditAppointmentDTO;
import com.example.DoctorAppointmentApp.dto.Appointment.RegisterAppointmentDTO;
import com.example.DoctorAppointmentApp.service.definition.AppointmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/appointments")
public class AppointmentController {


    private final AppointmentService appointmentService;

    @PostMapping
    public AppointmentDTO registerAppointment(@RequestBody RegisterAppointmentDTO registerAppointmentDTO){
        return appointmentService.registerAppointment(registerAppointmentDTO);
    }

    @GetMapping
    public List getAllAppointments(){
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public AppointmentDTO getAppointmentByID(@PathVariable int id){
        return appointmentService.getAppointmentById(id);
    }

    @GetMapping(params = "doctorId")
    public List getAppointmentsByDoctorId(@RequestParam long doctorId){
        return appointmentService.getAppointmentByDoctorId(doctorId);
    }

    @GetMapping(params = "patientId")
    public List getAppointmentsByPatientId(@RequestParam long patientId){
        return appointmentService.getAppointmentByPatientId(patientId);
    }


    @DeleteMapping("/{id}")
    public void deleteAppointmentById(@PathVariable long id){
        appointmentService.deleteAppointmentById(id);
    }

    @PutMapping("/{id}")
    public AppointmentDTO editAppointment(@PathVariable long id, @Valid @RequestBody EditAppointmentDTO editAppointmentDTO){
        return appointmentService.editAppointment(id, editAppointmentDTO);
    }
}
