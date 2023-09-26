package com.example.DocAppointmentSystem.Controller;

import com.example.DocAppointmentSystem.DTOs.RequestDto.DoctorDto;
import com.example.DocAppointmentSystem.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/add-doctor")
    public ResponseEntity<String> addDoctor(@RequestBody DoctorDto doctorDto){
        try{
            String message = doctorService.addDoctor(doctorDto);

            return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-doctor")
    public ResponseEntity<String> deleteDoctor(@RequestParam Integer doctorId){
        try{
            String message = doctorService.deleteDoctor(doctorId);

            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
