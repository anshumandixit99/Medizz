package com.example.Medical.service;

import com.example.Medical.DTO.RequestDTO;
import com.example.Medical.entity.Doctor;
import com.example.Medical.entity.Review;
import com.example.Medical.entity.Users;
import com.example.Medical.repository.DoctorRepository;
import com.example.Medical.repository.ReviewRepository;
import com.example.Medical.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    public Review addReview(RequestDTO request){
        Optional<Doctor> doctorOptional = doctorRepository.findById(request.getDoctorId());

        if(doctorOptional.isEmpty()){
            throw new IllegalArgumentException("Doctor not found");
        }

        Optional<Users> patientOptional = userRepository.findById(request.getPatientId());

        if(patientOptional.isEmpty()){
            throw new IllegalArgumentException("Patient not found");
        }

        Doctor doctor = doctorOptional.get();
        Users patient = patientOptional.get();

        Review review = new Review();
        review.setRating(request.getRating());
        review.setComment(request.getComment());
        review.setDoctor(doctor);
        review.setPatient(patient);

        reviewRepository.save(review);
        updateDoctorRating(doctor);

        return review;
    }

    private void updateDoctorRating(Doctor doctor){
        Double averageRating = doctor.getReviews().stream()
                .mapToDouble(Review::getRating)
                .average()
                .orElse(0.0);

        doctor.setRating(averageRating);

        doctorRepository.save(doctor);
    }

    public List<Review> getAllReviews(Long doctorId){

        return reviewRepository.findByDoctorId(doctorId);
    }
}
