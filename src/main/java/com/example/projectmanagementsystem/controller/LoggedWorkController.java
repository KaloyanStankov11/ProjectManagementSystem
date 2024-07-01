package com.example.projectmanagementsystem.controller;

import com.example.projectmanagementsystem.model.LoggedWorkRequest;
import com.example.projectmanagementsystem.model.Task;
import com.example.projectmanagementsystem.model.dto.LoggedWorkDTO;
import com.example.projectmanagementsystem.service.LoggedWorkService;
import com.example.projectmanagementsystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logged")
public class LoggedWorkController {

    @Autowired
    private LoggedWorkService loggedWorkService;

    @GetMapping("/user-logged")
    public ResponseEntity<List<LoggedWorkDTO>> getAllLoggedWork(){
        return ResponseEntity.ok().body(loggedWorkService.getUserLoggedWork());
    }

    @PostMapping("/add-logged")
    public ResponseEntity<List<LoggedWorkDTO>> addLoggedWork(@RequestBody LoggedWorkRequest loggedWorkDTO){
        return ResponseEntity.ok().body(loggedWorkService.addLoggedWork(loggedWorkDTO));
    }

    @DeleteMapping("/delete-logged/{id}")
    public ResponseEntity deleteLogged(@PathVariable Long id){
        loggedWorkService.deleteLoggedWork(id);
        return ResponseEntity.ok().build();
    }
}
