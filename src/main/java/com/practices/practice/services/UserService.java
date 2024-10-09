package com.practices.practice.services;

import com.practices.practice.entity.User;
import com.practices.practice.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public class UserService {


    @Autowired
    public UserRepository UserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void postData (@RequestBody User getData){
        String encodedPassword = passwordEncoder.encode(getData.getPassword());
        getData.setPassword(encodedPassword); // Set the encoded password back to the User object

        // Save the user with the encoded password
        UserRepository.save(getData);
    }

    public User getData(ObjectId id) {
        // Use findById to get a single user by ID
        return UserRepository.findById(id).orElse(null);  // Returns null if not found
    }


    public Boolean removeData (@RequestBody User getData){
        UserRepository.save(getData);
        return true;
    }
}
