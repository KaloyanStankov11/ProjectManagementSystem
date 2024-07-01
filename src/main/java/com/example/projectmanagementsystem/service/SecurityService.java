package com.example.projectmanagementsystem.service;

import com.example.projectmanagementsystem.model.AppUser;
import com.example.projectmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ServerErrorException;

import javax.persistence.NoResultException;

@Service
public class SecurityService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public AppUser createAppUser(AppUser user) {
        Boolean userExists = userRepository.existsAppUserByUsername(user.getUsername());
        if (userExists) {
            throw new ServerErrorException("User with that username already exists!");
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    public AppUser getAppUserByUsername(String username) {
        try {
            return userRepository.findAppUserByUsername(username);
        } catch (NoResultException e) {
            return null;
        }
    }
}
