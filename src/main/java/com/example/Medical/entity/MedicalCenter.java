package com.example.Medical.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;


@Data
@Entity
public class MedicalCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
    private String district;
    private Double feesForInClinicCheckUp;
    private String speciality;
    private String fullAddress;

    @OneToMany(mappedBy = "medicalCenter", cascade = CascadeType.ALL)
    private Map<String, String> timings = new HashMap<>();

    private String googleMapLocation;


}
