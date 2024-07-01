package com.example.projectmanagementsystem.service;

import com.example.projectmanagementsystem.model.Project;
import com.example.projectmanagementsystem.model.dto.ProjectDTO;
import com.example.projectmanagementsystem.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project getProjectById(Long id){
        return projectRepository.getProjectsById(id);
    }
    public Project getProjectByName(String name){
        return projectRepository.getProjectsByProjectName(name);
    }

    public List<ProjectDTO> getAllProjects(){
        return projectRepository.findAll().stream().map(Project::toProjectDTO).toList();
    }
}
