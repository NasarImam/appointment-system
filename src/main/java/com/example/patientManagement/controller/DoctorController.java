package com.example.patientManagement.controller;

import com.example.patientManagement.modals.Doctor;
import com.example.patientManagement.service.doctor.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor){
        Doctor doctorCreated=doctorService.createDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorCreated);

    }

    @GetMapping
    public  ResponseEntity<List<Doctor>> getAllDoctor(){
        List<Doctor> getDoctor=doctorService.getAllDoctor();
        return ResponseEntity.ok(getDoctor);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id){
        Doctor getById = doctorService.getDoctorById(id).orElseThrow(()-> new RuntimeException("Doctor not found"));
        return ResponseEntity.ok(getById);
    }
}
