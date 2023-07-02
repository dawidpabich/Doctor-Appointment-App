package com.example.DoctorAppointmentApp.mapper;

import com.example.DoctorAppointmentApp.dto.Appointment.AppointmentDTO;
import com.example.DoctorAppointmentApp.dto.Appointment.RegisterAppointmentDTO;
import com.example.DoctorAppointmentApp.model.appointments.Appointment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AppointmentMapper {
    AppointmentDTO mapAppointmentToAppointmentDTO(Appointment appointment);
    Appointment mapAppointmentDTOToAppointment(RegisterAppointmentDTO registerAppointmentDTO);
    List<AppointmentDTO> mapAppointmentsToAppointmentsDTO(List<Appointment> appointments);
}
