package com.example.patientManagement.repository;

import com.example.patientManagement.modals.Appointment;
import com.example.patientManagement.modals.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByPatient_Id(Long patientId);
    List<Appointment> findAllByDoctor_Id(Long doctorId);

    Boolean existsByDoctor_IdAndAppointmentTime(Long doctorId, LocalDateTime appointmentTime);
}
