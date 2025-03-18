package com.example.Medical.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DoctorSearchDTO {

    private String specialization;
    private String city;
    private String locality;
    private Boolean available;
    private Integer minExperience;
    private Double minFee;
    private Double maxFee;
    private Double minRating;
    private String gender;
    private List<String> symptoms;
    private String clinicName;
    private String consultationType;
    private String availableOption;
    private LocalDateTime chosenDate;
}
