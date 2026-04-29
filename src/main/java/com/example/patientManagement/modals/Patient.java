package com.example.patientManagement.modals;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends BaseModel {


    private String name;

    private String email_id;

    private Long contact_number;

    @OneToMany
    @JoinColumn(nullable = false)
    private List<Appointment> appointment;

}
