package com.example.patientManagement.modals;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import com.example.patientManagement.models.BaseModel;

import java.time.LocalDateTime;
import java.util.Date;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
// creating a unique constraints in DB to ensure not two columns row can be same
@Table(
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"doctor_id", "appointment_time"}
        )
)
public class Appointment extends BaseModel {

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private AppointmentStatus appointmentStatus;



    // appointment booking time
    @Column(nullable = false)
    LocalDateTime appointmentTime;

    //many appointment can be handled by only one doctor
    @ManyToOne
    @JoinColumn(name= "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id",nullable = false)
    private Patient patient;



}
