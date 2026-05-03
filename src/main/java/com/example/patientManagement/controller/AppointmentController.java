package com.example.patientManagement.controller;

import com.example.patientManagement.modals.Appointment;
import com.example.patientManagement.service.appointment.AppointmentService;
import com.example.patientManagement.service.department.DepartmentService;
import com.example.patientManagement.service.doctor.DoctorService;
import com.example.patientManagement.service.patient.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment){

        Appointment created= appointmentService.bookAppointment(
                appointment.getPatient().getId(),
                appointment.getDoctor().getId(),
                appointment.getAppointmentTime());

        return ResponseEntity.status(HttpStatus.CREATED).body(created);


    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity <Appointment> cancelAppointment(@PathVariable Long id){
        Appointment appointment=appointmentService.cancelAppointment(id);
        return ResponseEntity.ok(appointment);
    }

    @PatchMapping("/{id}/complete")
    public  ResponseEntity<Appointment> completeAppointment(@PathVariable Long id){
        Appointment completeAppointment=appointmentService.completeAppointment(id);
        return ResponseEntity.ok(completeAppointment);
    }

    @GetMapping("/patient/{id}")
    public  ResponseEntity<List<Appointment>> getAllAppointmentByPatient(@PathVariable Long id){
        List<Appointment> appointmentsOfPatients= appointmentService.getAllAppointmentByPatient(id);
        return ResponseEntity.ok(appointmentsOfPatients);
    }

    @GetMapping("/doctor/{id}")
    public  ResponseEntity<List<Appointment>> getAllAppointmentByDoctor(@PathVariable Long id){
        List<Appointment> appointmentsOfDoctor= appointmentService.getAllAppointmentByDoctor(id);
        return ResponseEntity.ok(appointmentsOfDoctor);
    }
}
