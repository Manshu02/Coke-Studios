package com.example.CokeStudios.util;

public class JwtResponse {
    private String token;
    private String username;
    private String role;
    private int id;
    public JwtResponse(String token, String username, String role,int id) {
        this.token = token;
        this.username = username;
        this.role = role;
        this.id=id;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
