package com.example.DoctorAppointmentApp.model.doctors;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="DOCTORS")
public class Doctor {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;;

    @Column(name="last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name="doctor_speciality")
    private DoctorSpeciality doctorSpeciality;
}
