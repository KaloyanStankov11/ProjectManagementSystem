package com.example.projectmanagementsystem.model;


import com.example.projectmanagementsystem.model.dto.UserRoleDTO;

import javax.persistence.Entity;

@Entity
public class UserRole extends _BaseEntity{
    private String roleName;

    public UserRoleDTO toUserRoleDTO(){
        return new UserRoleDTO(this.roleName);
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
