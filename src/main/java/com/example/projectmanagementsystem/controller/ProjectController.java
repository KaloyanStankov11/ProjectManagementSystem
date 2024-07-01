package com.example.projectmanagementsystem.controller;

import com.example.projectmanagementsystem.model.dto.ProjectDTO;
import com.example.projectmanagementsystem.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/allProjects")
    public ResponseEntity<List<ProjectDTO>> getAllProjects(){
        return ResponseEntity.ok().body(projectService.getAllProjects());
    }
}
