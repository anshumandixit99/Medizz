package com.example.Medical.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DoctorSignupDTO {

    private String name;
    private String specialization;
    private String city;
    private String locality;
    private Integer experience;
    private Double fee;
    private Double rating;
    private String gender;
    private List<String> symptoms;
    private String clinicName;
    private Boolean available;
    private String consultationType;
    private LocalDateTime availabilityTime;
}
