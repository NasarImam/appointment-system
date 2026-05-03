package com.example.patientManagement.controller;

import com.example.patientManagement.modals.Doctor;
import com.example.patientManagement.modals.Patient;
import com.example.patientManagement.service.patient.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }



    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient){
        Patient patientCreated=patientService.createPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(patientCreated);

    }

    @GetMapping
    public  ResponseEntity<List<Patient>> getAllPatient(){
        List<Patient> getPatient=patientService.getAllPatients();
        return ResponseEntity.ok(getPatient);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id){
        Patient getById = patientService.getPatientById(id).orElseThrow(()-> new RuntimeException("Patient not found"));
        return ResponseEntity.ok(getById);
    }
}
