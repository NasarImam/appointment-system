package com.example.patientManagement.repository;

import com.example.patientManagement.modals.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    boolean existsByEmail(String email);

}

