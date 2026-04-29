package com.example.patientManagement.service.patient;

import com.example.patientManagement.modals.Patient;

import java.util.List;
import java.util.Optional;

public interface



PatientService {
    Patient createPatient(Patient patient);
    Optional<Patient> getPatientById(Long id);
    List<Patient> getAllPatients();
}
