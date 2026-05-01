package com.example.patientManagement.service.appointment;

import com.example.patientManagement.modals.Appointment;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {

    Appointment bookAppointment(Long patientId, Long doctorId, LocalDateTime appointmentDate);
    Appointment cancelAppointment(Long appointmentId);
    Appointment completeAppointment(Long appointmentId);
    List<Appointment> getAllAppointmentByPatient(Long patientId);
}
