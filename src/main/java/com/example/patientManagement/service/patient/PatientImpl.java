package com.example.patientManagement.service.patient;

import com.example.patientManagement.modals.Patient;
import com.example.patientManagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service


public class PatientImpl  implements PatientService, CommandLineRunner{

    @Autowired
    private PatientRepository patientRepository;



    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override

    public Optional<Patient> getPatientById(Long id) {

        Optional<Patient> patient= patientRepository.findById(id);
        if (patient.isEmpty()) {
            System.out.println("Patient not found with id: " + id);
        }
        return patient;
    }

    @Override
    public List<Patient> getAllPatients() {
        return List.of();
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("====================================");

    }
}
