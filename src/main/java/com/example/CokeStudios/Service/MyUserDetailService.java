//package com.example.FakeTaxi.Service;
//
//import com.example.FakeTaxi.Entity.Users;
//import com.example.FakeTaxi.Entity.UserPrincipal;
//import com.example.FakeTaxi.repository.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.net.http.HttpResponse;
//
//@Service
//public class MyUserDetailService implements UserDetailsService {
//    @Autowired
//    private UserRepo userRepo;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println(username+"loadByUsername Called");
//        Users user=userRepo.findByuname(username);
//
//        System.out.println("User from repository: " + user);
//            if(user==null){
//                System.out.println("user not found");
//                System.out.println("From UserDetailed Service");
//
//                throw new UsernameNotFoundException("User not found");
//
//            }
//        return new UserPrincipal(user);
//    }
//    public void authenticate(String username, String rawPassword) {
//        UserDetails userDetails = loadUserByUsername(username);
//        if (!passwordEncoder.matches(rawPassword, userDetails.getPassword())) {
//            throw new BadCredentialsException("Incorrect password");
//        }
//    }
//}
