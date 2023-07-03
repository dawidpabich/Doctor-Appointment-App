package com.example.DoctorAppointmentApp.service;

import com.example.DoctorAppointmentApp.dto.doctor.DoctorDTO;
import com.example.DoctorAppointmentApp.dto.doctor.EditDoctorDTO;
import com.example.DoctorAppointmentApp.dto.doctor.RegisterDoctorDTO;
import com.example.DoctorAppointmentApp.mapper.DoctorMapper;
import com.example.DoctorAppointmentApp.model.doctors.Doctor;
import com.example.DoctorAppointmentApp.model.doctors.DoctorSpeciality;
import com.example.DoctorAppointmentApp.repository.DoctorRepository;
import com.example.DoctorAppointmentApp.service.implementation.DoctorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.DoctorAppointmentApp.model.doctors.DoctorSpeciality.NEUROLOGY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;
    @Mock
    private DoctorMapper doctorMapper;
    @InjectMocks
    private DoctorServiceImpl doctorService;

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
    public void givenRegisterDoctorDTO_whenCreated_thenReturnDoctorDTO(){

        RegisterDoctorDTO registerDoctorDTO = RegisterDoctorDTO.builder()
                .firstName("Paul")
                .lastName("Rider")
                .doctorSpeciality(DoctorSpeciality.DERMATOLOGY)
                .build();

        when(doctorMapper.mapDoctorToDoctorDTO(doctor)).thenReturn(doctorDTO);
        when(doctorMapper.mapDoctorDTOToDoctor(registerDoctorDTO)).thenReturn(doctor);
        when(doctorRepository.save(Mockito.any(Doctor.class))).thenReturn(doctor);

        DoctorDTO savedDoctor = doctorService.registerDoctor(registerDoctorDTO);

        assertThat(savedDoctor).isNotNull();
        assertThat(savedDoctor.getId()).isEqualTo(1L);
    }

    @Test
    public void givenDoctors_whenGetAllDoctors_thenReturnsDoctors() {

        Doctor doctor2 = Doctor.builder()
                .id(2L)
                .firstName("John")
                .lastName("Flower")
                .doctorSpeciality(NEUROLOGY)
                .build();

        DoctorDTO doctorDTO2 = DoctorDTO.builder()
                .id(2L)
                .firstName("John")
                .lastName("Flower")
                .doctorSpeciality(NEUROLOGY)
                .build();

        List<Doctor> doctors = new ArrayList<>(List.of(doctor, doctor2));
        List<DoctorDTO> doctorsDTO = new ArrayList<>(List.of(doctorDTO, doctorDTO2));


        when(doctorMapper.mapDoctorsToDoctorsDTO(doctors)).thenReturn(doctorsDTO);
        when(doctorRepository.findAll()).thenReturn(doctors);


        List<DoctorDTO> savedDoctorsDTO =  doctorService.getAllDoctors();
        assertThat(savedDoctorsDTO).isNotNull();
        assertThat(savedDoctorsDTO).hasSize(2);

    }

    @Test
    public void givenDoctor_whenGotById_thenReturnsDoctorDTO() {

        when(doctorMapper.mapDoctorToDoctorDTO(doctor)).thenReturn(doctorDTO);
        when(doctorRepository.findById(1L)).thenReturn(Optional.ofNullable(doctor));

        DoctorDTO savedDoctor = doctorService.getDoctorById(1L);

        assertThat(savedDoctor).isNotNull();
    }

    @Test
    public void givenDoctors_whenFindDoctorsBySpeciality_thenReturnsDoctorsDTO() {

        DoctorSpeciality doctorSpecialityToCheck = NEUROLOGY;
        List<Doctor> doctors = new ArrayList<>(List.of(doctor));
        List<DoctorDTO> doctorsDTO = new ArrayList<>(List.of(doctorDTO));

        when(doctorMapper.mapDoctorsToDoctorsDTO(doctors)).thenReturn(doctorsDTO);
        when(doctorRepository.findAllByDoctorSpeciality(doctorSpecialityToCheck)).thenReturn(doctors);


        List<DoctorDTO> savedDoctorsDTO =  doctorService.getDoctorsBySpeciality(doctorSpecialityToCheck);
        assertThat(savedDoctorsDTO).isNotNull();
        assertThat(savedDoctorsDTO).hasSize(1);
        assertThat(savedDoctorsDTO);
    }

    @Test
    public void givenId_whenDeleteDoctorById_thenReturnVoid() {
        long doctorId = 1L;

        when(doctorRepository.findById(1L)).thenReturn(Optional.ofNullable(doctor));

        assertAll(() -> doctorService.deleteDoctorById(1));

    }

    @Test
    public void givenEditDoctorDTO_whenEditDoctor_thenReturnDoctorDTO() {

        EditDoctorDTO editDoctorDTO = EditDoctorDTO.builder()
                .firstName("John")
                .lastName("Flower")
                .doctorSpeciality(NEUROLOGY)
                .build();

        when(doctorMapper.mapDoctorToDoctorDTO(doctor)).thenReturn(doctorDTO);
        when(doctorRepository.findById(1L)).thenReturn(Optional.ofNullable(doctor));
        when(doctorRepository.save(Mockito.any(Doctor.class))).thenReturn(doctor);

        DoctorDTO updatedDoctor = doctorService.editDoctor(1L, editDoctorDTO);

        assertThat(updatedDoctor).isNotNull();
        assertThat(doctor.getFirstName()).isEqualTo("John");
        assertThat(doctor.getLastName()).isEqualTo("Flower");
        assertThat(doctor.getDoctorSpeciality()).isEqualTo(NEUROLOGY);

    }
}