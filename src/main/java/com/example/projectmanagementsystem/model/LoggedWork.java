package com.example.projectmanagementsystem.model;



import com.example.projectmanagementsystem.model.dto.LoggedWorkDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class LoggedWork extends _BaseEntity{

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    @JsonBackReference
    private AppUser worker;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
    private Integer loggedTimeNumber;
    private String loggedTimeUnit;
    private LocalDate date;

    public LoggedWork(AppUser worker, Task task, Integer loggedTimeNumber, String loggedTimeUnit, LocalDate date) {
        this.worker = worker;
        this.task = task;
        this.loggedTimeNumber = loggedTimeNumber;
        this.loggedTimeUnit = loggedTimeUnit;
        this.date = date;
    }

    public LoggedWork() {
    }

    public LoggedWorkDTO toLoggedWorkDTO(){
        return new LoggedWorkDTO(
                this.id,
                this.worker.getUsername(),
                this.task.toTaskDTO(),
                new TimeMeasure(this.loggedTimeNumber, this.loggedTimeUnit),
                this.date
        );
    }

    public AppUser getWorker() {
        return worker;
    }

    public void setWorker(AppUser worker) {
        this.worker = worker;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
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
