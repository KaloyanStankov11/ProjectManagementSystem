package com.example.projectmanagementsystem.model.dto;

import java.util.List;

public class AppUserDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private UserRoleDTO userRole;
    private List<LoggedWorkDTO> loggedWork;

    public AppUserDTO() {
    }

    public AppUserDTO(Long id, String username, String email, String password, String phoneNumber, UserRoleDTO userRole, List<LoggedWorkDTO> loggedWork) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.userRole = userRole;
        this.loggedWork = loggedWork;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserRoleDTO getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleDTO userRole) {
        this.userRole = userRole;
    }

    public List<LoggedWorkDTO> getLoggedWork() {
        return loggedWork;
    }

    public void setLoggedWork(List<LoggedWorkDTO> loggedWork) {
        this.loggedWork = loggedWork;
    }
}
