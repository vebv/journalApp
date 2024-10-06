package com.practices.practice.controllers;

import com.practices.practice.entity.User;
import com.practices.practice.repository.UserRepository;
import com.practices.practice.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService UserService;

    @Autowired
    public UserRepository UserRepository;


    @GetMapping("/{Id}")
    public ResponseEntity<?> getData(@PathVariable String Id) {
        try {
            // Convert String id to ObjectId
            ObjectId objectId = new ObjectId(Id);

            User user = UserService.getData(objectId);

            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid ObjectId format");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while fetching user");
        }
    }


    @PostMapping
    public ResponseEntity<?> postData(@RequestBody User myData) {
        try {
            UserService.postData(myData); // assuming userService is injected, not static
            return ResponseEntity.status(HttpStatus.CREATED).body("Data added successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error occurred while adding data.");
        }
    }

}
