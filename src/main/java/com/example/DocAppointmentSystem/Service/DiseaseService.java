package com.example.DocAppointmentSystem.Service;

import com.example.DocAppointmentSystem.DTOs.RequestDto.DiseaseDto;
import com.example.DocAppointmentSystem.Models.Disease;
import com.example.DocAppointmentSystem.Repository.DiseaseRepository;
import com.example.DocAppointmentSystem.Transformers.DiseaseTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiseaseService {

    @Autowired
    DiseaseRepository diseaseRepository;

    public String addDisease(DiseaseDto diseaseDto) {
        Disease disease = DiseaseTransformer.convertDtoToEntity(diseaseDto);

        diseaseRepository.save(disease);

        return "Disease is stored with it's related category";
    }
}
