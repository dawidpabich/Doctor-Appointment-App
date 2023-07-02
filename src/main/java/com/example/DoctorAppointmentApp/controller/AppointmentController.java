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


    @DeleteMapping
    public void deleteAppointmentById(long id){
        appointmentService.deleteAppointmentById(id);
    }

    @PutMapping
    public AppointmentDTO editAppointment(long id, @Valid @RequestBody EditAppointmentDTO editAppointmentDTO){
        return appointmentService.editAppointment(id, editAppointmentDTO);
    }
}
