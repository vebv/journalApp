package com.practices.practice.services;

import com.practices.practice.entity.User;
import com.practices.practice.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public class UserService {


    @Autowired
    public UserRepository UserRepository;

    public void postData (@RequestBody User getData){
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
