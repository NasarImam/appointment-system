package com.example.patientManagement.modals;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends com.example.patientManagement.models.BaseModel {

    @Column(nullable = false)
    private String name;

    @Column(name = "email_id", nullable = false) // optional (for DB naming)
    private String email;

    @Column(nullable = false)
    private String contactNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    @Builder.Default
    private List<Appointment> appointments = new ArrayList<>();

}
