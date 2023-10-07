package com.example.DocAppointmentSystem.Service;

import com.example.DocAppointmentSystem.DTOs.RequestDto.AppointmentDto;
import com.example.DocAppointmentSystem.Exceptions.NoDoctorException;
import com.example.DocAppointmentSystem.Exceptions.PatientException;
import com.example.DocAppointmentSystem.Exceptions.SlotUnavailable;
import com.example.DocAppointmentSystem.Models.Appointment;
import com.example.DocAppointmentSystem.Models.Doctor;
import com.example.DocAppointmentSystem.Models.Patient;
import com.example.DocAppointmentSystem.Repository.AppointmentRepository;
import com.example.DocAppointmentSystem.Repository.DoctorRepository;
import com.example.DocAppointmentSystem.Repository.PatientRepository;
import com.example.DocAppointmentSystem.Transformers.AppointmentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    JavaMailSender mailSender;

    public String bookAppointment(AppointmentDto appointmentDto) throws PatientException, NoDoctorException, SlotUnavailable{
        int patientId = appointmentDto.getPatientId();
        int docId = appointmentDto.getDocId();

        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        Optional<Doctor> doctorOptional = doctorRepository.findById(docId);

        if(patientOptional.isEmpty()){
            throw new PatientException("Patient is not present in th database with id " +patientId);
        }
        if(doctorOptional.isEmpty()){
            throw new NoDoctorException("Doctor is not present in the database with id " + docId);
        }

        Patient patient = patientOptional.get();
        Doctor doctor = doctorOptional.get();

        String appointmentDate = appointmentDto.getAppointmentDate();
        String appointmentTime = appointmentDto.getAppointmentTime();

        if(!isDoctorAvailable(doctor,appointmentDate, appointmentTime)){
            throw new SlotUnavailable("There is no slot for given date and time.");
        }

        Appointment appointment = AppointmentTransformer.convertDtoToEntity(appointmentDto);
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        appointment = appointmentRepository.save(appointment);

        doctor.getAppointmentList().add(appointment);
        patient.setAppointment(appointment);

        doctorRepository.save(doctor);
        patientRepository.save(patient);

//        Sending the mail to the patient regarding the appointment
        sendMailRegardingAppointment(appointment, doctor, patient);

        return "Appointment booked successfully with doctor " + doctor.getName();
    }

    private boolean isDoctorAvailable(Doctor doctor, String appointmentDate, String appointmentTime) {
        List<Appointment> appointmentList = doctor.getAppointmentList();
        if(appointmentList.isEmpty()){
            return true;
        }

        for(Appointment appointment : appointmentList){
            if(appointment.getAppointmentDate().equals(appointmentDate) && appointment.getAppointmentTime().equals(appointmentTime)){
                return false;
            }
        }

        return true;
    }

    private void sendMailRegardingAppointment(Appointment appointment, Doctor doctor, Patient patient) {

        String body = " Hi ! "+patient.getName()+"\n" +
                "You have successfully booked an appointment on "+appointment.getAppointmentDate() + "at "+appointment.getAppointmentTime() + ","
                + " and your doctor is "+doctor.getName()+ "\n"+ ". Please be there on time." + "\n" +
                "Mask is mandatory!";

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("springtesting17@gmail.com");
        mailMessage.setTo(patient.getEmail());
        mailMessage.setSubject("Appointment Confirmed!!");
        mailMessage.setText(body);

        mailSender.send(mailMessage);
    }
}
