package com.example.projectmanagementsystem.model;

import com.example.projectmanagementsystem.model.dto.TaskDTO;

import java.time.LocalDate;

public class LoggedWorkRequest {
    private TaskDTO task;
    private Integer loggedTimeNumber;
    private String loggedTimeUnit;
    private LocalDate date;

    public LoggedWorkRequest(TaskDTO task, Integer loggedTimeNumber, String loggedTimeUnit, LocalDate date) {
        this.task = task;
        this.loggedTimeNumber = loggedTimeNumber;
        this.loggedTimeUnit = loggedTimeUnit;
        this.date = date;
    }

    public TaskDTO getTask() {
        return task;
    }

    public void setTask(TaskDTO task) {
        this.task = task;
    }

    public Integer getLoggedTimeNumber() {
        return loggedTimeNumber;
    }

    public void setLoggedTimeNumber(Integer loggedTimeNumber) {
        this.loggedTimeNumber = loggedTimeNumber;
    }

    public String getLoggedTimeUnit() {
        return loggedTimeUnit;
    }

    public void setLoggedTimeUnit(String loggedTimeUnit) {
        this.loggedTimeUnit = loggedTimeUnit;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
