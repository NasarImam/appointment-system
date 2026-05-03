package com.example.patientManagement.service.patient;

import com.example.patientManagement.modals.Patient;
import com.example.patientManagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service


public class PatientImpl  implements PatientService{

    private final PatientRepository patientRepository;

    public PatientImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }



    @Override
    public Patient createPatient(Patient patient) {

        if (patientRepository.existsByEmail(patient.getEmail())) {
            throw new RuntimeException("Patient with this email already exists");
        }

        Patient newPatient = Patient.builder()
                .name(patient.getName())
                .email(patient.getEmail())
                .contactNumber(patient.getContactNumber())
                .build();


        return patientRepository.save(newPatient);
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
        return patientRepository.findAll();
    }


}
