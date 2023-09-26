package com.example.DocAppointmentSystem.DTOs.RequestDto;

import com.example.DocAppointmentSystem.Enums.Speciality;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiseaseDto {

    private String diseaseName;

    private Speciality speciality;
}
