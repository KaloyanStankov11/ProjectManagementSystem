package com.example.projectmanagementsystem.repository;

import com.example.projectmanagementsystem.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole getUserRoleByRoleName(String roleName);
}
