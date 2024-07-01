package com.example.projectmanagementsystem.repository;

import com.example.projectmanagementsystem.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser findAppUserByUsername(String username);
    Boolean existsAppUserByUsername(String username);
}
