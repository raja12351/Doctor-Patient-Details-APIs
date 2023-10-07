package com.example.DocAppointmentSystem.Controller;

import com.example.DocAppointmentSystem.DTOs.RequestDto.AppointmentDto;
import com.example.DocAppointmentSystem.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PutMapping("/bookingAppointment")
    public ResponseEntity<String> bookAppointment(@RequestBody AppointmentDto appointmentDto){
        try{
            String message = appointmentService.bookAppointment(appointmentDto);

            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
