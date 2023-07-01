package com.example.DoctorAppointmentApp.repository;

import com.example.DoctorAppointmentApp.model.patients.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
}
