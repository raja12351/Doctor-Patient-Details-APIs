package com.example.DocAppointmentSystem.Service;

import com.example.DocAppointmentSystem.DTOs.RequestDto.DoctorDto;
import com.example.DocAppointmentSystem.Exceptions.*;
import com.example.DocAppointmentSystem.Models.Doctor;
import com.example.DocAppointmentSystem.Repository.DoctorRepository;
import com.example.DocAppointmentSystem.Transformers.DoctorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public String addDoctor(DoctorDto doctorDto) throws NameException, CityException, EmailException, NumberException{
        Doctor doctor = DoctorTransformer.convertDtoToEntity(doctorDto);

        if(doctor.getName().length() < 3){
            throw new NameException("The length of the name should be 3 at least.");
        }
        if(doctor.getCity().toString().length() > 20){
            throw new CityException("The length of the city name should be 20 at max");
        }
        if(!doctor.getEmail().contains("@gmail.com")){
            throw new EmailException("Proper email id needed");
        }
        if(doctor.getMobileNo().length() < 10){
            throw new NumberException("Given mobile number is not valid, check that again.");
        }

        doctorRepository.save(doctor);

        return "Doctor is registered successfully.";
    }

    public String deleteDoctor(Integer doctorId) throws NoDoctorException{

        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);

        if(doctorOptional.isEmpty()){
            throw new NoDoctorException("No doctor present with given id");
        }

        Doctor doctor = doctorOptional.get();

        doctorRepository.delete(doctor);

        return "Doctor is deleted from the database successfully.";
    }
}
