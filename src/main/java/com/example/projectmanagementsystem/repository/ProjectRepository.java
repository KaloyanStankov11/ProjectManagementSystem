package com.example.projectmanagementsystem.repository;

import com.example.projectmanagementsystem.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project getProjectsById(Long id);
    Project getProjectsByProjectName(String projectName);
}
