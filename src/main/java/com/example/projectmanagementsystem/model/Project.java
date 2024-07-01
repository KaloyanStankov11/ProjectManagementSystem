package com.example.projectmanagementsystem.model;


import com.example.projectmanagementsystem.model.dto.ProjectDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Project extends _BaseEntity{
    private String projectName;
    @ManyToOne
    @JsonBackReference
    private AppUser projectManager;
    @ManyToMany(targetEntity = AppUser.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AppUser> workers;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Task> tasks;
    @ManyToOne
    private Organization organization;

    public ProjectDTO toProjectDTO(){
        return new ProjectDTO(
                this.projectName,
                this.projectManager.getUsername(),
                this.workers.stream().map(AppUser::toAppUserDTO).toList(),
                this.tasks.stream().map(Task::toTaskDTO).toList(),
                this.organization.getName()
        );
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public AppUser getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(AppUser projectManager) {
        this.projectManager = projectManager;
    }

    public List<AppUser> getWorkers() {
        return workers;
    }

    public void setWorkers(List<AppUser> workers) {
        this.workers = workers;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
