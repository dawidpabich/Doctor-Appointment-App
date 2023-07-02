package com.example.DoctorAppointmentApp.model.appointments;

import com.example.DoctorAppointmentApp.model.doctors.Doctor;
import com.example.DoctorAppointmentApp.model.patients.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="APPOINTMENTS")
public class Appointment {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name="id")
    private long id;

    @Column(name="REGISTER_DATE")
    private LocalDateTime registerDate;

    @Column(name="Appointment_DATE")
    private LocalDateTime appointmentDate;

    @Column(name="ADDITIONAL_INFORMATION")
    private String additionalInformation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "DOCTOR_ID", nullable = false)
    private Doctor doctor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "PATIENT_ID", nullable = false)
    private Patient patient;




}
