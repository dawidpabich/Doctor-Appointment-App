package com.example.DoctorAppointmentApp.repository;

import com.example.DoctorAppointmentApp.model.doctors.Doctor;
import com.example.DoctorAppointmentApp.model.doctors.DoctorSpeciality;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
   List<Doctor> findAllByDoctorSpeciality(DoctorSpeciality doctorSpeciality);


}
