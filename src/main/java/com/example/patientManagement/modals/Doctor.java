package com.example.patientManagement.modals;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doctor extends com.example.patientManagement.models.BaseModel {

    @Column(nullable = false)
    private String name;


    @Column(nullable = false)
    private String emailId;


    @Column(nullable = false)
    private String contactNumber;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    //one doctor can have many appointment
    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
    @Builder.Default
    private List<Appointment> appointments = new ArrayList<>();


}
