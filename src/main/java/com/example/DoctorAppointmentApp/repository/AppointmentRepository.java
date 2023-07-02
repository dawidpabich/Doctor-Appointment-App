package com.example.DoctorAppointmentApp.repository;

import com.example.DoctorAppointmentApp.model.appointments.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
