package com.example.projectmanagementsystem.model.dto;

import com.example.projectmanagementsystem.model.*;


import java.time.LocalDateTime;

public class TaskDTO {
    private Long id;
    private String caption;
    private String description;
    private AppUserDTO assignee;
    private LocalDateTime creationTime;
    private String project;
    private TaskStatus taskStatus;
    private TimeMeasure estimatedTime;
    private String creator;

    public TaskDTO() {
    }

    public TaskDTO(Long id, String caption, String description, AppUserDTO assignee, LocalDateTime creationTime, String project, TaskStatus taskStatus, TimeMeasure estimatedTime, String creator) {
        this.id = id;
        this.caption = caption;
        this.description = description;
        this.assignee = assignee;
        this.creationTime = creationTime;
        this.project = project;
        this.taskStatus = taskStatus;
        this.estimatedTime = estimatedTime;
        this.creator = creator;
    }

    public Task toTask(){
        return new Task(
              this.caption,
              this.description,
              this.creationTime,
              this.taskStatus,
              this.estimatedTime.getNumber(),
              this.estimatedTime.getUnit()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AppUserDTO getAssignee() {
        return assignee;
    }

    public void setAssignee(AppUserDTO assignee) {
        this.assignee = assignee;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public TimeMeasure getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(TimeMeasure estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
