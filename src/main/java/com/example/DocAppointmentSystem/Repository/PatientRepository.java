package com.example.DocAppointmentSystem.Repository;

import com.example.DocAppointmentSystem.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
