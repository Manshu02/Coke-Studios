package com.example.CokeStudios.Service;

import com.example.CokeStudios.Entity.Users;
import com.example.CokeStudios.repository.UserRepo;
import com.example.CokeStudios.util.JwtResponse;
import com.example.CokeStudios.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

      private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public Users register(Users user){
        user.setuPassword(encoder.encode(user.getuPassword()));
        userRepo.save(user);
        return user;
    }
    public ResponseEntity<?> login(Users user) {
        Users existingUser = userRepo.findByuname(user.getUname());
        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
        }

        if (encoder.matches(user.getuPassword(), existingUser.getuPassword())) {
            String token = jwtTokenUtil.generateToken(user.getUname(), existingUser.getRole());
            return ResponseEntity.ok(new JwtResponse(token,existingUser.getUname(),existingUser.getRole(),existingUser.getId()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
        }
    }
    public Users getUser(String name){
       return userRepo.findByuname(name);
    }
}
