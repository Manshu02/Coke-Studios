//package com.example.FakeTaxi.config;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
//
//    @Override
//    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//        String errorMessage = "Authentication failed";
//        System.out.println("Exception class: " + exception.getClass().getName());
//        System.out.println("Exception message: " + exception.getMessage());
//
//        if (exception instanceof UsernameNotFoundException) {
//            errorMessage = "User not found";
//            System.out.println(errorMessage);
//        } else if (exception instanceof BadCredentialsException) {
//            errorMessage = "Incorrect password";
//            System.out.println(errorMessage);
//        } else {
//            errorMessage = "Authentication failed";
//        }
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 Unauthorized
//        response.setContentType("application/json");
//        response.getWriter().write("{\"error\":\"" + errorMessage + "\"}");
//    }
//}
