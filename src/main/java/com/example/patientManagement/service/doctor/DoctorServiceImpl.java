package com.example.patientManagement.service.doctor;

import com.example.patientManagement.modals.Department;
import com.example.patientManagement.modals.Doctor;
import com.example.patientManagement.repository.DepartmentRepository;
import com.example.patientManagement.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Doctor createDoctor(Doctor doctor) {

        // extract the department ID from incoming request
        Long departmentId= doctor.getDepartment().getId();
        // check with correct Department ID if not found throw exception
        Department department=departmentRepository.findById(departmentId).orElseThrow(()-> new RuntimeException("Department not found"));

        // check if doctor is already present or not
        if(doctorRepository.existsByEmailId(doctor.getEmailId())){
            throw new RuntimeException("Doctor with this email ID already exist");
        }

        //set new department for doctor
        doctor.setDepartment(department);


        return doctorRepository.save(doctor);

    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }



    @Override
    public List<Doctor> getAllDoctor() {
        return doctorRepository.findAll();
    }
}
