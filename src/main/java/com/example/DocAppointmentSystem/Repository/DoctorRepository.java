package com.example.DocAppointmentSystem.Repository;

import com.example.DocAppointmentSystem.Enums.Speciality;
import com.example.DocAppointmentSystem.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
