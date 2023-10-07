package com.example.DocAppointmentSystem.Transformers;

import com.example.DocAppointmentSystem.DTOs.RequestDto.AppointmentDto;
import com.example.DocAppointmentSystem.DTOs.ResponseDto.Appointments;
import com.example.DocAppointmentSystem.Models.Appointment;

public class AppointmentTransformer {

    public static Appointment convertDtoToEntity(AppointmentDto appointmentDto){
        Appointment appointment = Appointment.builder().appointmentDate(appointmentDto.getAppointmentDate())
                .appointmentTime(appointmentDto.getAppointmentTime()).build();

        return appointment;
    }

    public static Appointments convertEntityToDto(Appointment appointment){
        Appointments appointments = Appointments.builder().patientName(appointment.getPatient().getName())
                .appointmentDate(appointment.getAppointmentDate()).appointmentTime(appointment.getAppointmentTime())
                .build();

        return appointments;
    }
}
