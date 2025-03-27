//package com.example.Medical.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.Date;
//
//@Data
//@Entity
//public class Message {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "chat_id")
//    private Chat chat;
//
//    @ManyToOne
//    @JoinColumn(name="sender_id")
//    private Users senderPatient;
//
//    @ManyToOne
//    @JoinColumn(name="sender_id")
//    private Doctor sendorDoctor;
//
//    private String message;
//
//    private Date timeStamp;
//}
