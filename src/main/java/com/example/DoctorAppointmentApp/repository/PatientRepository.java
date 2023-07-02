package com.example.DoctorAppointmentApp.repository;

import com.example.DoctorAppointmentApp.model.patients.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
