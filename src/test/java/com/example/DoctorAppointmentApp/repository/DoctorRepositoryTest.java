package com.example.DoctorAppointmentApp.repository;

import com.example.DoctorAppointmentApp.model.doctors.Doctor;
import com.example.DoctorAppointmentApp.model.doctors.DoctorSpeciality;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class DoctorRepositoryTest {

    @Autowired
    private DoctorRepository doctorRepository;
    private Doctor doctor;



    @BeforeEach
    public void setup(){
        doctor = Doctor.builder()
                .firstName("John")
                .lastName("Thorn")
                .doctorSpeciality(DoctorSpeciality.NEUROLOGY)
                .build();
    }

    @AfterEach
    public void tearDown(){
        doctorRepository.deleteAll();
    }


    @DisplayName("Test for find all by doctor speciality operation")
    @Test
    void givenDoctorsList_whenFindAllByDoctorSpeciality_thenReturnDoctorsList() {

        //given
        Doctor doctor2 = Doctor.builder()
                .firstName("Paul")
                .lastName("Rider")
                .doctorSpeciality(DoctorSpeciality.DERMATOLOGY)
                .build();

        doctorRepository.save(doctor);
        doctorRepository.save(doctor2);

        //when
        List<Doctor> doctorList = doctorRepository.findAllByDoctorSpeciality(doctor.getDoctorSpeciality());

        //then
        assertThat(doctorList).isNotNull();
        assertThat(doctorList).contains(doctor);
        assertThat(doctorList).doesNotContain(doctor2);
        assertThat(doctorList)
                .extracting(Doctor::getDoctorSpeciality)
                .containsOnly(doctor.getDoctorSpeciality());

    }
}