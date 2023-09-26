package com.example.DocAppointmentSystem.Transformers;

import com.example.DocAppointmentSystem.DTOs.RequestDto.PatientDto;
import com.example.DocAppointmentSystem.Models.Patient;

public class PatientTransformer {
    public static Patient convertDtoToEntity(PatientDto patientDto){
        Patient patient = Patient.builder().name(patientDto.getName()).city(patientDto.getCity())
                .email(patientDto.getEmail()).mobileNo(patientDto.getMobileNo())
                .symptom(patientDto.getSymptom()).build();

        return patient;
    }
}
