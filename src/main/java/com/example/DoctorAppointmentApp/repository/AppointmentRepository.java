package com.example.DoctorAppointmentApp.repository;

import com.example.DoctorAppointmentApp.model.appointments.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAppointmentsByDoctor_Id(long doctorId);
    List<Appointment> findAppointmentsByPatient_Id(long patientId);
}
