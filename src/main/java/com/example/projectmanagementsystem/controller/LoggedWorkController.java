package com.example.projectmanagementsystem.controller;

import com.example.projectmanagementsystem.model.Task;
import com.example.projectmanagementsystem.model.dto.LoggedWorkDTO;
import com.example.projectmanagementsystem.service.LoggedWorkService;
import com.example.projectmanagementsystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/add-logged")
    public ResponseEntity addLoggedWork(@RequestBody LoggedWorkDTO loggedWorkDTO){
        loggedWorkService.addLoggedWork(loggedWorkDTO);
        return ResponseEntity.ok().build();
    }
}
