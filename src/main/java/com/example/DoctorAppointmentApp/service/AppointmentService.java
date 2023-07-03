package com.example.DoctorAppointmentApp.service;

import com.example.DoctorAppointmentApp.dto.Appointment.AppointmentDTO;
import com.example.DoctorAppointmentApp.dto.Appointment.EditAppointmentDTO;
import com.example.DoctorAppointmentApp.dto.Appointment.RegisterAppointmentDTO;

import java.util.List;

public interface AppointmentService {

    AppointmentDTO registerAppointment(RegisterAppointmentDTO appointment);
    List<AppointmentDTO> getAllAppointments();
    AppointmentDTO getAppointmentById(long id);
    List<AppointmentDTO> getAppointmentByDoctorId(long doctorID);

    List<AppointmentDTO> getAppointmentByPatientId(long patientId);

    void deleteAppointmentById(long id);
    AppointmentDTO editAppointment(long id, EditAppointmentDTO appointment);
}
