package com.example.DocAppointmentSystem.Models;

import com.example.DocAppointmentSystem.Enums.Speciality;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "diseases")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer diseaseId;

    private String diseaseName;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;
}
