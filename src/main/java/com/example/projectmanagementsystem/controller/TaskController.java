package com.example.projectmanagementsystem.controller;

import com.example.projectmanagementsystem.model.dto.LoggedWorkDTO;
import com.example.projectmanagementsystem.model.dto.TaskDTO;
import com.example.projectmanagementsystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("allTasks")
    public ResponseEntity<List<TaskDTO>> getAllTasks(){
        return ResponseEntity.ok().body(taskService.getAllTasks());
    }

    @GetMapping("userTasks/{username}")
    public ResponseEntity<List<TaskDTO>> getAllTasksByUser(@PathVariable String username){
        return ResponseEntity.ok().body(taskService.getAllTasksByUser(username));
    }

    @PostMapping("/create")
    public ResponseEntity<Long> createTask(@RequestBody TaskDTO task){
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @PostMapping("/update")
    public ResponseEntity updateTask(@RequestBody TaskDTO task){
        taskService.updateTask(task);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<TaskDTO> getTask(@RequestParam Long id){
        return ResponseEntity.ok().body(taskService.getTaskById(id));
    }

    @GetMapping("/project-tasks/{project}")
    public ResponseEntity<List<TaskDTO>> getTasksForProject(@PathVariable String project){
        return ResponseEntity.ok().body(taskService.getProjectTasks(project));
    }

    @GetMapping("/task-logged/{taskId}")
    public ResponseEntity<String> getTaskLoggedWork(@PathVariable Long taskId){
        return ResponseEntity.ok().body(taskService.getTaskLoggedWork(taskId));
    }

    @GetMapping("/user-tasks")
    public ResponseEntity<List<TaskDTO>> getUserTasks(){
        return ResponseEntity.ok().body(taskService.getUserTasks());
    }
}
