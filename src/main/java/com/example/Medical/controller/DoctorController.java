package com.example.Medical.controller;

import com.example.Medical.DTO.DoctorSearchDTO;
import com.example.Medical.DTO.DoctorSignupDTO;
import com.example.Medical.entity.Doctor;
import com.example.Medical.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/signup")
    public ResponseEntity<Doctor> signupDoctor(@RequestBody DoctorSignupDTO doctorSignupDTO) {
        Doctor doctor = doctorService.signupDoctor(doctorSignupDTO);
        return ResponseEntity.ok(doctor);
    }

    @GetMapping("/search")
    public List<Doctor> searchDoctors(@ModelAttribute DoctorSearchDTO request) {
        return doctorService.searchDoctors(request);
    }
}