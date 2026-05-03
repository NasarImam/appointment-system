package com.example.patientManagement.service.department;

import com.example.patientManagement.modals.Department;
import com.example.patientManagement.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

public interface
DepartmentService {

    Department createDepartment(String name);
    Optional<Department> getDepartmentById(Long id);
    List<Department> getAllDepartment();
}
