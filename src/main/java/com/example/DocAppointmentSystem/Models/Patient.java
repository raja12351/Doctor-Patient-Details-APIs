package com.example.DocAppointmentSystem.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patients")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;

    private String name;

    private String city;

    private String email;

    private String mobileNo;

    private String symptom;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
    private Appointment appointment;
}
