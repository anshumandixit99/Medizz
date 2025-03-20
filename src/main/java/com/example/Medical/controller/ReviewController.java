package com.example.Medical.controller;

import com.example.Medical.DTO.RequestDTO;
import com.example.Medical.entity.Review;
import com.example.Medical.service.ReviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/add")
    public ResponseEntity<?> addReview(@ModelAttribute RequestDTO request){
        try{
            Review review = reviewService.addReview(request);
            return new ResponseEntity<>(review, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<?> getReviewsDoctor(@PathVariable("doctorId") Long doctorId){
        List<Review> reviews = reviewService.getAllReviews(doctorId);

        if(reviews.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
}
