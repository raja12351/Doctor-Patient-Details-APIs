package com.example.DocAppointmentSystem.Service;

import com.example.DocAppointmentSystem.DTOs.RequestDto.PatientDto;
import com.example.DocAppointmentSystem.DTOs.ResponseDto.DoctorList;
import com.example.DocAppointmentSystem.Enums.Speciality;
import com.example.DocAppointmentSystem.Exceptions.*;
import com.example.DocAppointmentSystem.Models.Disease;
import com.example.DocAppointmentSystem.Models.Doctor;
import com.example.DocAppointmentSystem.Models.Patient;
import com.example.DocAppointmentSystem.Repository.DiseaseRepository;
import com.example.DocAppointmentSystem.Repository.DoctorRepository;
import com.example.DocAppointmentSystem.Repository.PatientRepository;
import com.example.DocAppointmentSystem.Transformers.DoctorTransformer;
import com.example.DocAppointmentSystem.Transformers.PatientTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    DiseaseRepository diseaseRepository;

    public String addPatient(PatientDto patientDto) throws NameException,CityException,EmailException,NumberException{
        Patient patient = PatientTransformer.convertDtoToEntity(patientDto);

        if(patient.getName().length() < 3){
            throw new NameException("The length of the name should be 3 at least.");
        }
        if(patient.getCity().length() > 20){
            throw new CityException("The length of the city name should be 20 at max");
        }
        if(!patient.getEmail().contains("@gmail.com")){
            throw new EmailException("Proper email id needed");
        }
        if(patient.getMobileNo().length() < 10){
            throw new NumberException("Given mobile number is not valid, check that again.");
        }

        patientRepository.save(patient);

        return "Patient is added to the database";
    }

    public List<DoctorList> getDoctors(Integer patientId) throws PatientException, CityException, NoDoctorException {
        List<Doctor> doctorList = doctorRepository.findAll();

        Optional<Patient> patientOptional = patientRepository.findById(patientId);

        if(patientOptional.isEmpty()){
            throw new PatientException("No patient with given id");
        }

        Patient patient = patientOptional.get();

        String symptom = patient.getSymptom();
        String city = patient.getCity();

        Disease disease = diseaseRepository.findByDiseaseName(symptom);
        Speciality speciality = disease.getSpeciality();

//        Checking for all the doctors available for given symptom
        List<Doctor> listOfDoctors = requiredDoctors(doctorList, speciality);

//        Checking for all the specialist doctors available in the city
        List<Doctor> doctorsInCity = doctorsInCity(listOfDoctors, city);

        List<DoctorList> returnlist = new ArrayList<>();
        for(Doctor doctor : doctorsInCity){
            DoctorList doctorList1 = DoctorTransformer.convertEntityToDto(doctor);
            returnlist.add(doctorList1);
        }

        return returnlist;
    }

    private List<Doctor> doctorsInCity(List<Doctor> listOfDoctors, String city) throws CityException{
        List<Doctor> doctorsAvailable = new ArrayList<>();

        for(Doctor doctor : listOfDoctors){
            if(doctor.getCity().toString().equals(city)){
                doctorsAvailable.add(doctor);
            }
        }
        if(doctorsAvailable.isEmpty()){
            throw new CityException("We are still waiting to expand to your location");
        }

        return doctorsAvailable;
    }

    private List<Doctor> requiredDoctors(List<Doctor> doctorList, Speciality speciality) throws NoDoctorException{
        List<Doctor> listOfDoctors = new ArrayList<>();

        for(Doctor doctor : doctorList){
            if(doctor.getSpeciality().toString().equals(speciality.toString())){
                listOfDoctors.add(doctor);
            }
        }
        if(listOfDoctors.isEmpty()){
            throw new NoDoctorException("There isn’t any doctor present at your location for your symptom");
        }

        return listOfDoctors;
    }

    public String deletePatient(Integer patientId) throws PatientException{
        Optional<Patient> patientOptional = patientRepository.findById(patientId);

        if(patientOptional.isEmpty()){
            throw new PatientException("No patient with given id");
        }

        Patient patient = patientOptional.get();

        patientRepository.delete(patient);

        return "Patient is deleted from the database successfully.";
    }
}
