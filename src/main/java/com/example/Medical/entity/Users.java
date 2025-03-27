package com.example.Medical.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false,unique = true)
    private String uid;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

}
