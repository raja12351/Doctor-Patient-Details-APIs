package com.example.DocAppointmentSystem.DTOs.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {

    private String name;

    private String city;

    private String email;

    private String mobileNo;

    private String symptom;

}
