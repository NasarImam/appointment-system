package com.example.patientManagement.controller;

import com.example.patientManagement.modals.Department;
import com.example.patientManagement.service.department.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department){
        Department createdDepartment=departmentService.createDepartment(department.getName());

        return ResponseEntity.status(HttpStatus.CREATED).body(createdDepartment);
    }

    @GetMapping
    public  ResponseEntity<List<Department>> getAllDepartment(){
        List<Department> getDepartment=departmentService.getAllDepartment();
        return ResponseEntity.status(HttpStatus.CREATED).body(getDepartment);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Department> getDepartmentById(@PathVariable Long id){
       Department getById=departmentService.getDepartmentById(id).orElseThrow(()-> new RuntimeException("Department not found"));
        return ResponseEntity.ok(getById);
    }

}

