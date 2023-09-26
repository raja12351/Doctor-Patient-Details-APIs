package com.example.DocAppointmentSystem.Controller;

import com.example.DocAppointmentSystem.DTOs.RequestDto.DiseaseDto;
import com.example.DocAppointmentSystem.Service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diseases")
public class DiseaseController {

    @Autowired
    DiseaseService diseaseService;

    @PostMapping("/add-disease")
    public ResponseEntity<String> addDisease(@RequestBody DiseaseDto diseaseDto){
        try{
            String message = diseaseService.addDisease(diseaseDto);

            return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
