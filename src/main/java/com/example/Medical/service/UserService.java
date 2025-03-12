package com.example.Medical.service;

import com.example.Medical.entity.Users;
import com.example.Medical.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<Users> getUserById(String uid){
        return userRepository.findByUid(uid);
    }

    public void saveUser(Users user) {
        userRepository.save(user);
        //new file sadasfa
    }

}
