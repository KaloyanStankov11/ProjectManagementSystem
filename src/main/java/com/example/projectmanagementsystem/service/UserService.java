package com.example.projectmanagementsystem.service;

import com.example.projectmanagementsystem.model.AppUser;
import com.example.projectmanagementsystem.model.dto.AppUserDTO;
import com.example.projectmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<AppUserDTO> getAllUsers(){
        return userRepository.findAll().stream().map(AppUser::toAppUserDTO).toList();
    }

    public AppUser getUserByUsername(String username){
        return userRepository.findAppUserByUsername(username);
    }
    public AppUser getUSerById(Long id){
        return userRepository.getReferenceById(id);
    }
}
