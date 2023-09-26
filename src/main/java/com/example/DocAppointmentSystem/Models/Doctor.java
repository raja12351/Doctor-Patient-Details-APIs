package com.example.DocAppointmentSystem.Models;

import com.example.DocAppointmentSystem.Enums.City;
import com.example.DocAppointmentSystem.Enums.Speciality;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "doctors")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer docId;

    private String name;

    @Enumerated(EnumType.STRING)
    private City city;

    private String email;

    private String mobileNo;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;

}
