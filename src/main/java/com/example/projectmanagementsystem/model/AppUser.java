package com.example.projectmanagementsystem.model;

import com.example.projectmanagementsystem.model.dto.AppUserDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class AppUser extends _BaseEntity{
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;
    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<LoggedWork> loggedWork;

    public AppUser(String username, String email, String password, String phoneNumber, UserRole userRole) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.userRole = userRole;
        this.loggedWork = Collections.emptyList();
    }

    public AppUser() {
    }

    public AppUserDTO toAppUserDTO(){
        return new AppUserDTO(
                this.id,
                this.username,
                this.email,
                this.password,
                this.phoneNumber,
                this.userRole.toUserRoleDTO(),
                this.loggedWork.stream().map(LoggedWork::toLoggedWorkDTO).toList()
        );
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

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public List<LoggedWork> getLoggedWork() {
        return loggedWork;
    }

    public void setLoggedWork(List<LoggedWork> loggedWork) {
        this.loggedWork = loggedWork;
    }
}
