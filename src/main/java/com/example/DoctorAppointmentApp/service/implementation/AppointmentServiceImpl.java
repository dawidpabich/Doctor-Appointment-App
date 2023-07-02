package com.example.DoctorAppointmentApp.service.implementation;

import com.example.DoctorAppointmentApp.dto.Appointment.AppointmentDTO;
import com.example.DoctorAppointmentApp.dto.Appointment.EditAppointmentDTO;
import com.example.DoctorAppointmentApp.dto.Appointment.RegisterAppointmentDTO;
import com.example.DoctorAppointmentApp.exception.doctor.DoctorNotFoundException;
import com.example.DoctorAppointmentApp.exception.patient.PatientNotFoundException;
import com.example.DoctorAppointmentApp.mapper.AppointmentMapper;
import com.example.DoctorAppointmentApp.model.appointments.Appointment;
import com.example.DoctorAppointmentApp.model.doctors.Doctor;
import com.example.DoctorAppointmentApp.model.patients.Patient;
import com.example.DoctorAppointmentApp.repository.AppointmentRepository;
import com.example.DoctorAppointmentApp.repository.DoctorRepository;
import com.example.DoctorAppointmentApp.repository.PatientRepository;
import com.example.DoctorAppointmentApp.service.definition.AppointmentService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {


    private final AppointmentMapper appointmentMapper;
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;


    @Transactional
    @Override
    public AppointmentDTO registerAppointment(RegisterAppointmentDTO appointment) {
        Appointment appointmentToRegister = appointmentMapper.mapAppointmentDTOToAppointment(appointment);

        Doctor doctor = doctorRepository.findById(appointment.getDoctorID()).orElseThrow(DoctorNotFoundException::new);
        Patient patient = patientRepository.findById(appointment.getPatientID()).orElseThrow(PatientNotFoundException::new);

        appointmentToRegister.setDoctor(doctor);
        appointmentToRegister.setPatient(patient);
        appointmentToRegister.setRegisterDate(LocalDateTime.now());

        Appointment registeredAppointment = appointmentRepository.save(appointmentToRegister);

        return appointmentMapper.mapAppointmentToAppointmentDTO(registeredAppointment);

    }

    @Override
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentMapper.mapAppointmentsToAppointmentsDTO(
                appointmentRepository.findAll());
    }

    @Override
    public AppointmentDTO getAppointmentById(long id) {
        return appointmentMapper.
                mapAppointmentToAppointmentDTO(
                        appointmentRepository.
                                findById(id).
                                orElseThrow());
    }


    @Transactional
    @Override
    public void deleteAppointmentById(long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow();
        appointmentRepository.delete(appointment);
    }
    @Transactional
    @Override
    public AppointmentDTO editAppointment(long id, EditAppointmentDTO appointment) {
        Appointment appointmentToEdit = appointmentRepository.findById(id).orElseThrow();

        appointmentToEdit.setAppointmentDate(appointment.getAppointmentDate());

        Appointment editedAppointment = appointmentRepository.save(appointmentToEdit);
        AppointmentDTO editedAppointmentDTO = appointmentMapper.mapAppointmentToAppointmentDTO(editedAppointment);
        return editedAppointmentDTO;
    }


}
