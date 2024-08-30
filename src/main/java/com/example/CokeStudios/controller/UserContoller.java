package com.example.CokeStudios.controller;

import com.example.CokeStudios.Entity.Users;
import com.example.CokeStudios.Service.UserService;
import com.example.CokeStudios.repository.UserRepo;
import com.example.CokeStudios.util.PasswordUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserContoller {

    @Autowired
    UserService userService;

    @Autowired
    UserRepo userRepo;

  private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Users user) {
        Users existingUser = userRepo.findByuname(user.getUname());
        if (existingUser!=null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }
        userService.register(user);
        return ResponseEntity.ok("User registered successfully");
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Users user) {
        //  handled by Spring Security
       return userService.login(user);
    }
    @GetMapping("/user/{name}")
    public Users findUser(@PathVariable String name){
       return userService.getUser(name);
    }
    @PostMapping("/updatePassword")
    public ResponseEntity<String> updatePassword(@RequestBody PasswordUpdateRequest request) {
        Users user = userRepo.findByuname(request.getUsername());

        if (user != null) {
            user.setuPassword(encoder.encode((request.getNewPassword())));
            userRepo.save(user);
            return ResponseEntity.ok("Password updated successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }


}
