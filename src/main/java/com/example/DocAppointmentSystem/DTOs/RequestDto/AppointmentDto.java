package com.example.DocAppointmentSystem.DTOs.RequestDto;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
public class AppointmentDto {
    private int docId;

    private int patientId;

    private String appointmentTime;

    private String appointmentDate;
}
