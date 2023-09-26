package com.example.DocAppointmentSystem.Transformers;

import com.example.DocAppointmentSystem.DTOs.RequestDto.DoctorDto;
import com.example.DocAppointmentSystem.DTOs.ResponseDto.DoctorList;
import com.example.DocAppointmentSystem.Models.Doctor;

public class DoctorTransformer {

    public static Doctor convertDtoToEntity(DoctorDto doctorDto){
        Doctor doctor = Doctor.builder().name(doctorDto.getName()).city(doctorDto.getCity())
                        .email(doctorDto.getEmail()).mobileNo(doctorDto.getMobileNo())
                        .speciality(doctorDto.getSpeciality()).build();

        return doctor;
    }

    public static DoctorList convertEntityToDto(Doctor doctor){
        DoctorList doctorList = DoctorList.builder().name(doctor.getName()).mobileNo(doctor.getMobileNo())
                .city(doctor.getCity()).build();

        return doctorList;
    }
}
