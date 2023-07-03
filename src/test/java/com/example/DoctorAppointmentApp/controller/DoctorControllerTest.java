package com.example.DoctorAppointmentApp.controller;

import com.example.DoctorAppointmentApp.dto.doctor.DoctorDTO;
import com.example.DoctorAppointmentApp.dto.doctor.EditDoctorDTO;
import com.example.DoctorAppointmentApp.dto.doctor.RegisterDoctorDTO;
import com.example.DoctorAppointmentApp.model.doctors.Doctor;
import com.example.DoctorAppointmentApp.model.doctors.DoctorSpeciality;
import com.example.DoctorAppointmentApp.service.DoctorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;

import static com.example.DoctorAppointmentApp.model.doctors.DoctorSpeciality.NEUROLOGY;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = DoctorController.class)
@ExtendWith(MockitoExtension.class)
class DoctorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DoctorService doctorService;

    @Autowired
    private ObjectMapper objectMapper;

    private Doctor doctor;
    private DoctorDTO doctorDTO;

    @BeforeEach
    public void setUp() {
        doctor = Doctor.builder()
                .id(1L)
                .firstName("Paul")
                .lastName("Rider")
                .doctorSpeciality(DoctorSpeciality.DERMATOLOGY)
                .build();

        doctorDTO = DoctorDTO.builder()
                .id(1L)
                .firstName("Paul")
                .lastName("Rider")
                .doctorSpeciality(DoctorSpeciality.DERMATOLOGY)
                .build();

    }

    @Test
    public void whenCreateDoctor_thenReturnCreated() throws Exception {

        RegisterDoctorDTO registerDoctorDTO = RegisterDoctorDTO.builder()
                .firstName("George")
                .lastName("Rider")
                .doctorSpeciality(DoctorSpeciality.DERMATOLOGY)
                .build();

        when(doctorService.registerDoctor(registerDoctorDTO)).thenReturn(doctorDTO);

        mockMvc.perform(post("/api/doctors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(registerDoctorDTO)))
                .andExpect(status().isOk());
    }

    @Test
    void whenGetAllDoctors_thenReturnDoctorsDTO() throws Exception {

        List<DoctorDTO> doctorsDTO = new ArrayList<>(List.of(doctorDTO));
        when(doctorService.getAllDoctors()).thenReturn(doctorsDTO);

        mockMvc.perform(get("/api/doctors")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("Paul"));
    }

    @Test
    void getDoctorByID() throws Exception {
        long doctorId = 1;
        when(doctorService.getDoctorById(doctorId)).thenReturn(doctorDTO);

        mockMvc.perform(get("/api/doctors/{id}", doctorId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Paul"));

    }

    @Test
    void getDoctorsBySpeciality() throws Exception {
        DoctorSpeciality doctorSpeciality = DoctorSpeciality.DERMATOLOGY;

        List<DoctorDTO> doctorsDTO = new ArrayList<>(List.of(doctorDTO));
        when(doctorService.getDoctorsBySpeciality(doctorSpeciality)).thenReturn(doctorsDTO);

        mockMvc.perform(get("/api/doctors/doctor-speciality?doctorSpeciality=DERMATOLOGY")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].doctorSpeciality").value(doctorSpeciality.name()));
    }

    @Test
    void deleteDoctorById() throws Exception {
        long doctorId = 1;

        doNothing().when(doctorService).deleteDoctorById(doctorId);

        mockMvc.perform(delete("/api/doctors/{id}", doctorId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void editDoctor() throws Exception {
        long doctorId = 1;
        EditDoctorDTO editDoctorDTO = EditDoctorDTO.builder()
                .firstName("John")
                .lastName("Flower")
                .doctorSpeciality(NEUROLOGY)
                .build();

        when(doctorService.editDoctor(doctorId, editDoctorDTO)).thenReturn(
                DoctorDTO.builder()
                        .id(doctorId)
                        .firstName("John")
                        .lastName("Flower")
                        .doctorSpeciality(NEUROLOGY)
                        .build()
        );

        mockMvc.perform(put("/api/doctors/{id}", doctorId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(editDoctorDTO)))
                .andExpect(status().isOk());
    }
}