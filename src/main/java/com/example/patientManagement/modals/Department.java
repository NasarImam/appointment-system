package com.example.patientManagement.modals;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department extends com.example.patientManagement.models.BaseModel {

    //department name

    @Column(nullable = false)
    private  String name;

    // one department can have many doctors

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<Doctor> doctors=new ArrayList<>();
}
