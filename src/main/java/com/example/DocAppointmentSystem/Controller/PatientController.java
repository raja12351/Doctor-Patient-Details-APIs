package com.example.DocAppointmentSystem.Controller;

import com.example.DocAppointmentSystem.DTOs.RequestDto.PatientDto;
import com.example.DocAppointmentSystem.DTOs.ResponseDto.DoctorList;
import com.example.DocAppointmentSystem.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/add-patient")
    public ResponseEntity<String> addPatient(@RequestBody PatientDto patientDto){
        try{
            String message = patientService.addPatient(patientDto);

            return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find-doctors")
    public ResponseEntity<List<DoctorList>> getDoctors(@RequestParam Integer patientId){
        try{
            List<DoctorList> doctorList = patientService.getDoctors(patientId);

            return new ResponseEntity<>(doctorList, HttpStatus.OK);
        }catch(Exception e){
            List<DoctorList> doctorList = new ArrayList<>();

            return new ResponseEntity<>(doctorList, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-patient")
    public ResponseEntity<String> deletePatient(@RequestParam Integer patientId){
        try{
            String message = patientService.deletePatient(patientId);

            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
