package com.example.DocAppointmentSystem.DTOs.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Appointments {

    private String patientName;

    private String appointmentDate;

    private String appointmentTime;
}
