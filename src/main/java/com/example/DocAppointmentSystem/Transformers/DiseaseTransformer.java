package com.example.DocAppointmentSystem.Transformers;

import com.example.DocAppointmentSystem.DTOs.RequestDto.DiseaseDto;
import com.example.DocAppointmentSystem.Models.Disease;

public class DiseaseTransformer {

    public static Disease convertDtoToEntity(DiseaseDto diseaseDto){
        Disease disease = Disease.builder().diseaseName(diseaseDto.getDiseaseName())
                .speciality(diseaseDto.getSpeciality()).build();

        return disease;
    }
}
