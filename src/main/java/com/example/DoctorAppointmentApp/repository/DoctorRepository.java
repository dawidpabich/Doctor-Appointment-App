package com.example.DoctorAppointmentApp.repository;

import com.example.DoctorAppointmentApp.model.appointments.Appointment;
import com.example.DoctorAppointmentApp.model.doctors.Doctor;
import com.example.DoctorAppointmentApp.model.doctors.DoctorSpeciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
   List<Doctor> findAllByDoctorSpeciality(DoctorSpeciality doctorSpeciality);
}
