package com.example.Medical.DTO;

import lombok.Data;
import java.util.List;

@Data
public class RequestDTO {

    //For patients
    private String uid;
    private String phoneNumber;

    //For doctors
    private String name;
    private String specialization;
    private String city;
    private String state;
    private int experience;
    private double fee;
    private double rating;
    private String language;
    private String clinicName;
    private List<String> symptoms;
    private Boolean available;

    //For review
    private Long doctorId;
    private Long patientId;
    private String comment;

    //For message
    private Long chatId;
    private Long senderId;
    private String messageContent;


}
