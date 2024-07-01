package com.example.projectmanagementsystem.controller;

import com.example.projectmanagementsystem.model.AppUser;
import com.example.projectmanagementsystem.model.RegisterUserRequest;
import com.example.projectmanagementsystem.model.UserRole;
import com.example.projectmanagementsystem.model.UserRoles;
import com.example.projectmanagementsystem.model.dto.AppUserDTO;
import com.example.projectmanagementsystem.repository.UserRepository;
import com.example.projectmanagementsystem.repository.UserRoleRepository;
import com.example.projectmanagementsystem.service.SecurityService;
import com.example.projectmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private SecurityService securityService;

    @GetMapping("/all")
    public ResponseEntity<List<AppUserDTO>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PostMapping("/save")
    public ResponseEntity createUser(@RequestBody RegisterUserRequest request){
        AppUserDTO userDetails = request.getUserInfo();
        UserRole role;
        if (request.getManager()) {
            role = userRoleRepository.getUserRoleByRoleName(UserRoles.MANAGER.toString());
        } else {
            role = userRoleRepository.getUserRoleByRoleName(UserRoles.WORKER.toString());
        }
        AppUser user = new AppUser(
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getUsername(),
                userDetails.getPhoneNumber(),
                role
        );
        return ResponseEntity.ok().body(securityService.createAppUser(user));
    }

    @DeleteMapping("/delete-user/{username}")
    public ResponseEntity<List<AppUserDTO>> deleteUser(@PathVariable String username){
        return ResponseEntity.ok().body(userService.deleteUser(username));
    }
}
