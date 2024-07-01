package com.example.projectmanagementsystem.model;

import com.example.projectmanagementsystem.model.dto.AppUserDTO;

public class RegisterUserRequest {
    private AppUserDTO userInfo;
    private Boolean manager;

    public AppUserDTO getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(AppUserDTO userInfo) {
        this.userInfo = userInfo;
    }

    public Boolean getManager() {
        return manager;
    }

    public void setManager(Boolean manager) {
        this.manager = manager;
    }
}
