package com.example.patientManagement.service.department;

import com.example.patientManagement.modals.Department;
import com.example.patientManagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    DepartmentRepository departmentRepository;


    @Override
    public Department createDepartment(String name) {
        Department department1=new Department();

        department1.setName(name);
        return departmentRepository.save(department1);

    }



    @Override
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }


    @Override
    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }

}
