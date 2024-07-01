package com.example.projectmanagementsystem.model;

import com.example.projectmanagementsystem.model.dto.OrganizationDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Organization extends _BaseEntity {
    private String name;
    @OneToOne
    @JoinColumn(name = "app_user_id")
    private AppUser owner;
    @OneToMany(mappedBy = "organization", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Project> projects;

    public OrganizationDTO toOrganizationDTO(){
        return new OrganizationDTO(
                this.name,
                this.owner.toAppUserDTO(),
                this.projects.stream().map(Project::toProjectDTO).toList()
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AppUser getOwner() {
        return owner;
    }

    public void setOwner(AppUser owner) {
        this.owner = owner;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
