package com.example.DocAppointmentSystem.DTOs.ResponseDto;

import com.example.DocAppointmentSystem.Enums.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorList {

    private String name;

    private String mobileNo;

    private City city;

}
