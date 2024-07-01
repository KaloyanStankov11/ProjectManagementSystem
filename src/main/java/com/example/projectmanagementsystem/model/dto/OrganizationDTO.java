package com.example.projectmanagementsystem.model.dto;

import com.example.projectmanagementsystem.model.AppUser;
import com.example.projectmanagementsystem.model.Project;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

public class OrganizationDTO {

    private String name;
    private AppUserDTO owner;
    private List<ProjectDTO> projects;

    public OrganizationDTO(String name, AppUserDTO owner, List<ProjectDTO> projects) {
        this.name = name;
        this.owner = owner;
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AppUserDTO getOwner() {
        return owner;
    }

    public void setOwner(AppUserDTO owner) {
        this.owner = owner;
    }

    public List<ProjectDTO> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDTO> projects) {
        this.projects = projects;
    }
}
