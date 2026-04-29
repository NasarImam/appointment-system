package com.example.patientManagement.modals;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doctor extends BaseModel{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String emailId;


    @Column(nullable = false)
    private Long contactNumber;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    //one doctor can have many appointment
    @OneToMany
    private List<Appointment> appointment;

}
