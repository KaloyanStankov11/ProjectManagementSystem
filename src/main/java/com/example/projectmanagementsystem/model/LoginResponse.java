package com.example.projectmanagementsystem.model;

import java.io.Serializable;
import java.util.List;

public class LoginResponse implements Serializable {

    String username;

    List<String> authorities;

    public LoginResponse(String username, List<String> authorities) {
        this.username = username;
        this.authorities = authorities;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }
}
