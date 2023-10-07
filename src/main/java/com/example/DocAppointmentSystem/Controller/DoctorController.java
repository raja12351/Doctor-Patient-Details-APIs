package com.example.DocAppointmentSystem.Controller;

import com.example.DocAppointmentSystem.DTOs.RequestDto.DoctorDto;
import com.example.DocAppointmentSystem.DTOs.ResponseDto.Appointments;
import com.example.DocAppointmentSystem.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/get-all-appointments")
    public ResponseEntity<List<Appointments>> getAllAppointments(@RequestParam Integer doctorId){
        try{
            List<Appointments> appointments = doctorService.getAllAppointments(doctorId);

            return new ResponseEntity<>(appointments, HttpStatus.OK);
        }catch(Exception e){
            List<Appointments> appointments = new ArrayList<>();

            return new ResponseEntity<>(appointments,HttpStatus.BAD_REQUEST);
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
