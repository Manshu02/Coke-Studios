package com.example.CokeStudios.config;

import com.example.CokeStudios.util.JwtTokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class JwtAuthenticationFilter implements Filter {


    private JwtTokenUtil jwtTokenUtil =new JwtTokenUtil();
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String path = httpRequest.getRequestURI();

        // Allow requests to /login and /register
        if (path.startsWith("/login") || path.startsWith("/register")) {
            chain.doFilter(request, response);
            return;
        }
        String authHeader = httpRequest.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            System.out.println("token : "+token);

                String username = jwtTokenUtil.getUsernameFromToken(token);
                System.out.println("USername :"+username);
                if (username != null && jwtTokenUtil.validateToken(token, username)) {
                    // Token is valid, proceed with the request
                    chain.doFilter(request, response);
                    return;
                }

        }

        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpResponse.setContentType("application/json");
        ServletOutputStream outputStream = httpResponse.getOutputStream();

        // Create an error response
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Unauthorized");
        errorResponse.put("message", "The token is either missing or invalid.");

        // Write the error response as JSON
        String jsonResponse = objectMapper.writeValueAsString(errorResponse);
        outputStream.write(jsonResponse.getBytes());
        outputStream.flush();
    }

    @Override
    public void destroy() {
        // Cleanup logic if needed
    }
}

