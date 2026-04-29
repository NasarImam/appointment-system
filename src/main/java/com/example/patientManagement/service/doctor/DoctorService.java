package com.example.patientManagement.service.doctor;

import com.example.patientManagement.modals.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    Doctor createDoctor(Doctor doctor);

    Optional<Doctor> getDoctorById(Long id);

    List<Doctor> getAllDoctor();

}
