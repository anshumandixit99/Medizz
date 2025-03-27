package com.example.Medical.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class MedicalCenterTimings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private String day;
    private String time;

    @ManyToOne
    @JoinColumn(name = "medical_center_id",nullable = false)
    private MedicalCenter medicalCenter;
}
