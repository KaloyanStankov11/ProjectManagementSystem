package com.example.projectmanagementsystem.model.dto;

public class UserRoleDTO {

    private String roleName;

    public UserRoleDTO() {
    }

    public UserRoleDTO(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
