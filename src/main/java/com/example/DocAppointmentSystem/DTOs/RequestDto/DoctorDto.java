package com.example.DocAppointmentSystem.DTOs.RequestDto;

import com.example.DocAppointmentSystem.Enums.City;
import com.example.DocAppointmentSystem.Enums.Speciality;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {

    private String name;

    private City city;

    private String email;

    private String mobileNo;

    private Speciality speciality;
}
