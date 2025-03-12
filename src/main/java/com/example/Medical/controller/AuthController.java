package com.example.Medical.controller;

import com.example.Medical.DTO.RequestDTO;
import com.example.Medical.Utility.JwtUtil;
import com.example.Medical.entity.Users;
import com.example.Medical.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> loginWithFirebase(@ModelAttribute RequestDTO request) {
        Users user = new Users();
        user.setUid(request.getUid());
        user.setPhoneNumber(request.getPhoneNumber());
        userService.saveUser(user);

        String token = jwtUtil.generateToken(request.getUid());
        return ResponseEntity.ok().body("Token: " + token);
    }

}
