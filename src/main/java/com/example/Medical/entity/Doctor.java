package com.example.Medical.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Table(name = "doctors")
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialization;
    private String city;
    private String locality;
    private Integer experience;
    private Double fee;
    private Double rating;
    private String gender;

    @ElementCollection
    private List<String> symptoms;

    private String clinicName;

    private Boolean available;

    private String consultationType;

    private LocalDateTime availabilityTime;

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    private List<Review> reviews;
}
