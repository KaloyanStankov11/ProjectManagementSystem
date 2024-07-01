package com.example.projectmanagementsystem.model.dto;

import com.example.projectmanagementsystem.model.AppUser;
import com.example.projectmanagementsystem.model.LoggedWork;
import com.example.projectmanagementsystem.model.Task;
import com.example.projectmanagementsystem.model.TimeMeasure;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class LoggedWorkDTO {

    private AppUserDTO worker;
    private TaskDTO task;
    private TimeMeasure loggedTime;
    private LocalDate date;

    public LoggedWorkDTO(AppUserDTO worker, TaskDTO task, TimeMeasure loggedTime, LocalDate date) {
        this.worker = worker;
        this.task = task;
        this.loggedTime = loggedTime;
        this.date = date;
    }

    public AppUserDTO getWorker() {
        return worker;
    }

    public void setWorker(AppUserDTO worker) {
        this.worker = worker;
    }

    public TaskDTO getTask() {
        return task;
    }

    public void setTask(TaskDTO task) {
        this.task = task;
    }

    public TimeMeasure getLoggedTime() {
        return loggedTime;
    }

    public void setLoggedTime(TimeMeasure loggedTime) {
        this.loggedTime = loggedTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
