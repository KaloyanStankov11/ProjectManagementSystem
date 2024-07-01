package com.example.projectmanagementsystem.model.dto;

import com.example.projectmanagementsystem.model.AppUser;
import com.example.projectmanagementsystem.model.Organization;
import com.example.projectmanagementsystem.model.Task;

import javax.persistence.*;
import java.util.List;

public class ProjectDTO {
    private String projectName;
    private String projectManager;
    private List<AppUserDTO> workers;
    private List<TaskDTO> tasks;
    private String organization;

    public ProjectDTO(String projectName,
                      String projectManager,
                      List<AppUserDTO> workers,
                      List<TaskDTO> tasks,
                      String organization) {
        this.projectName = projectName;
        this.projectManager = projectManager;
        this.workers = workers;
        this.tasks = tasks;
        this.organization = organization;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public List<AppUserDTO> getWorkers() {
        return workers;
    }

    public void setWorkers(List<AppUserDTO> workers) {
        this.workers = workers;
    }

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
