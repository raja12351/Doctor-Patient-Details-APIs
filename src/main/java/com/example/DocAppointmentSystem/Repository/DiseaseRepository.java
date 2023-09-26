package com.example.DocAppointmentSystem.Repository;

import com.example.DocAppointmentSystem.Models.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Integer> {

    Disease findByDiseaseName(String diseaseName);
}
