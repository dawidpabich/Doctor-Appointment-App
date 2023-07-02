package com.example.DoctorAppointmentApp.service.implementation;

import com.example.DoctorAppointmentApp.dto.doctor.DoctorDTO;
import com.example.DoctorAppointmentApp.dto.doctor.EditDoctorDTO;
import com.example.DoctorAppointmentApp.dto.doctor.RegisterDoctorDTO;
import com.example.DoctorAppointmentApp.exception.doctor.DoctorNotFoundException;
import com.example.DoctorAppointmentApp.mapper.DoctorMapper;
import com.example.DoctorAppointmentApp.model.doctors.Doctor;
import com.example.DoctorAppointmentApp.model.doctors.DoctorSpeciality;
import com.example.DoctorAppointmentApp.repository.DoctorRepository;
import com.example.DoctorAppointmentApp.service.definition.DoctorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {


    private final DoctorMapper doctorMapper;
    private final DoctorRepository doctorRepository;

    @Transactional
    @Override
    public DoctorDTO registerDoctor(RegisterDoctorDTO doctor) {
        Doctor doctorToRegister = doctorMapper.mapDoctorDTOToDoctor(doctor);
        Doctor registeredDoctor = doctorRepository.save(doctorToRegister);
        return doctorMapper.mapDoctorToDoctorDTO(registeredDoctor);

    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        return doctorMapper.mapDoctorsToDoctorsDTO(doctorRepository.findAll());
    }

    @Override
    public DoctorDTO getDoctorById(long id) {
        return doctorMapper.mapDoctorToDoctorDTO(doctorRepository.findById(id).
                orElseThrow(DoctorNotFoundException::new));
    }

    @Override
    public List<DoctorDTO> getDoctorsBySpeciality(DoctorSpeciality doctorSpeciality){
        return doctorMapper.mapDoctorsToDoctorsDTO(doctorRepository.findAllByDoctorSpeciality(doctorSpeciality));
    }

    @Transactional
    @Override
    public void deleteDoctorById(long id) {
        Doctor doctor = doctorRepository.findById(id).
                orElseThrow(DoctorNotFoundException::new);
        doctorRepository.delete(doctor);
    }

    @Transactional
    @Override
    public DoctorDTO editDoctor(long id, EditDoctorDTO doctor) {
        Doctor doctorToEdit = doctorRepository.findById(id).
                orElseThrow(DoctorNotFoundException::new);

        doctorToEdit.setFirstName(doctor.getFirstName());
        doctorToEdit.setLastName(doctor.getLastName());
        doctorToEdit.setDoctorSpeciality(doctor.getDoctorSpeciality());

        Doctor editedDoctor = doctorRepository.save(doctorToEdit);
        return doctorMapper.mapDoctorToDoctorDTO(editedDoctor);
    }
}
