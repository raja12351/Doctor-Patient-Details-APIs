package com.example.DocAppointmentSystem.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "appointments")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String appointmentDate; //YYYY-MM-DD

    private String appointmentTime; //HH:MM:SS

    @ManyToOne
    @JoinColumn
    private Doctor doctor;

    @OneToOne
    @JoinColumn
    private Patient patient;
}
