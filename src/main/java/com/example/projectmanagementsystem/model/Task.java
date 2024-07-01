package com.example.projectmanagementsystem.model;


import com.example.projectmanagementsystem.model.dto.TaskDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Task extends _BaseEntity {
    private String caption;
    private String description;
    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser assignee;
    private LocalDateTime creationTime;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "project_id")
    private Project project;
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;
    private Integer estimationTimeNumber;
    private String estimationTimeUnit;
    @ManyToOne
    @JoinColumn(name = "creator")
    private AppUser creator;

    public Task(String caption, String description, LocalDateTime creationTime, TaskStatus taskStatus, Integer estimationTimeNumber, String estimationTimeUnit) {
        this.caption = caption;
        this.description = description;
        this.creationTime = creationTime;
        this.taskStatus = taskStatus;
        this.estimationTimeNumber = estimationTimeNumber;
        this.estimationTimeUnit = estimationTimeUnit;
    }

    public Task() {
    }

    public TaskDTO toTaskDTO(){
        return new TaskDTO(
                this.id,
                this.caption,
                this.description,
                this.assignee.toAppUserDTO(),
                this.creationTime,
                this.project.getProjectName(),
                this.taskStatus,
                new TimeMeasure(this.estimationTimeNumber, this.estimationTimeUnit),
                this.creator.getUsername()
        );
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

    public AppUser getAssignee() {
        return assignee;
    }

    public void setAssignee(AppUser assignee) {
        this.assignee = assignee;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Integer getEstimationTimeNumber() {
        return estimationTimeNumber;
    }

    public void setEstimationTimeNumber(Integer estimationTimeNumber) {
        this.estimationTimeNumber = estimationTimeNumber;
    }

    public String getEstimationTimeUnit() {
        return estimationTimeUnit;
    }

    public void setEstimationTimeUnit(String estimationTimeUnit) {
        this.estimationTimeUnit = estimationTimeUnit;
    }

    public AppUser getCreator() {
        return creator;
    }

    public void setCreator(AppUser createdBy) {
        this.creator = createdBy;
    }
}
