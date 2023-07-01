package com.example.DoctorAppointmentApp.service.implementation;

import com.example.DoctorAppointmentApp.dto.doctor.DoctorDTO;
import com.example.DoctorAppointmentApp.dto.doctor.EditDoctorDTO;
import com.example.DoctorAppointmentApp.dto.doctor.RegisterDoctorDTO;
import com.example.DoctorAppointmentApp.mapper.DoctorMapper;
import com.example.DoctorAppointmentApp.model.doctors.Doctor;
import com.example.DoctorAppointmentApp.model.doctors.DoctorSpeciality;
import com.example.DoctorAppointmentApp.repository.DoctorRepository;
import com.example.DoctorAppointmentApp.service.definition.DoctorService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {


    private final DoctorMapper doctorMapper;
    private final DoctorRepository doctorRepository;


    @Override
    public DoctorDTO registerDoctor(RegisterDoctorDTO doctor) {
        Doctor doctorToRegister = doctorMapper.mapDoctorDTOToDoctor(doctor);
        Doctor registeredDoctor = doctorRepository.save(doctorToRegister);
        return doctorMapper.mapDoctorToDoctorDTO(registeredDoctor);

    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        return doctorMapper.mapDoctorsToDoctorsDTO(
                (List<Doctor>) doctorRepository.findAll());
    }

    @Override
    public DoctorDTO getDoctorById(int id) {
        return doctorMapper.
                mapDoctorToDoctorDTO(
                        doctorRepository.
                                findById(id).
                                orElseThrow());
    }

    @Override
    public List<DoctorDTO> getDoctorsBySpeciality(DoctorSpeciality doctorSpeciality){
        return doctorMapper.mapDoctorsToDoctorsDTO(doctorRepository.findAllByDoctorSpeciality(doctorSpeciality));
    }

    @Override
    public void deleteDoctorById(int id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        doctorRepository.delete(doctor);
    }

    @Override
    public DoctorDTO editDoctor(int id, EditDoctorDTO doctor) {
        Doctor doctorToEdit = doctorRepository.findById(id).orElseThrow();

        doctorToEdit.setFirstName(doctor.getFirstName());
        doctorToEdit.setLastName(doctor.getLastName());
        doctorToEdit.setDoctorSpeciality(doctor.getDoctorSpeciality());

        Doctor editedDoctor = doctorRepository.save(doctorToEdit);
        DoctorDTO editedDoctorDTO = doctorMapper.mapDoctorToDoctorDTO(doctorToEdit);
        return editedDoctorDTO;
    }
}
